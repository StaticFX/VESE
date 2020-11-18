package de.vese.vese.simulation.company;

import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.market.Market;
import de.vese.vese.simulation.market.Offer;
import de.vese.vese.simulation.participant.Job;
import de.vese.vese.simulation.participant.Participant;
import de.vese.vese.simulation.participant.Trait;
import de.vese.vese.simulation.util.Util;

import java.util.List;
import java.util.UUID;

/*
    VESE - Item
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
public class Company {

    private final double PROFITMARGINCHANGE = 0.005;
    private final double DOWNSIZINGPROFITMARGIN = 0.03;
    private final double EXPANDPROFITMARGIN = 0.15;
    private final int HIRINGMAX = 2;
    private final double EVALUATIONCHANGE = 200;

    private List<Job> jobs;
    private Item product;
    private int stock;
    private double lastExpenses;
    private double capital;
    private double profitMargin;
    private double hiringEvaluation;
    public Company(List<Job> jobs, Item product, int stock, double profitMargin, double lastExpenses, double capital, double hiringEvaluation) {
        this.jobs = jobs;
        this.capital = capital;
        this.product = product;
        this.stock = stock;
        this.profitMargin = profitMargin;
        this.lastExpenses = lastExpenses;
        this.hiringEvaluation = hiringEvaluation;
    }
    //Self-made functions
    public void updateStats(UUID id) {
        //update lastExpenses
        double expense = 0.0;
        //add expenses (WIP)
        lastExpenses += expense;
        //fire Participants if profitmargin too low
        if (profitMargin < DOWNSIZINGPROFITMARGIN) {
            //If profitmargin lower than a certain point then downsize (fire Participants)
            fireParticipant(getWorstParticipant());
        }
        //hire Participant if profitmargin too high
        if(profitMargin > EXPANDPROFITMARGIN) {
            hireParticipant(id);
        }
    }
    public void produce() {
        stock += (int) (calculateProductionPoints()/product.getProductionCosts());
    }
    public void payParticipants() {
        double expense = 0;
        for (Job job : jobs) {
            capital -= job.getPay();
            expense += job.getPay();
            job.getParticipant().setCapital(job.getParticipant().getCapital() + job.getPay());
        }
        lastExpenses = 0;
        lastExpenses += expense;
    }
    public void offerProduct() {
        Market market = Util.getMarket(product);
        double prize = (lastExpenses/stock) * (1 + profitMargin);
        market.makeOffer(new Offer(product, prize, stock, this));
        stock = 0;
    }
    public void changeProfitMargin() {
        if (stock > 0) {
            //Too much leftover ergo lower the profitmargin
            profitMargin -= PROFITMARGINCHANGE;
        } else {
            //Higher the profit margin (since everything was sold)
            profitMargin += PROFITMARGINCHANGE;
        }
    }
    public Participant getWorstParticipant() {
        Participant worstParticipant = jobs.get(0).getParticipant();
        double worstProductionCostRatio = -100000;
        for (int i = 0; i < jobs.size(); i++) {
            double productionCostRatio = calcParticipantProductionPoints(jobs.get(i).getParticipant())/jobs.get(i).getPay();
            if (worstProductionCostRatio == -100000 || productionCostRatio < worstProductionCostRatio) {
                worstProductionCostRatio = productionCostRatio;
                worstParticipant = jobs.get(i).getParticipant();
            }
        }
        return worstParticipant;
    }
    public void fireParticipant(Participant participant) {
        jobs.remove(participant.getJob());
        participant.setJob(null);
    }
    public void hireParticipant(UUID id) {
        //Go through all unemployed Participants and offer the ones above a certain level a job with a salarie
        List<Participant> unemployed = Util.getJobMarket(id).getUnemployed();
        List<Participant> participants = null;
        for(Participant kek : unemployed) {
            double eval = evaluateParticipant(kek);
            if (eval > hiringEvaluation) {
                participants.add(kek);
            }
        }
        //Calculate Income the Participant generates and let Pay equal a fraction of that.
        int outbidded = 0;
        for(Participant participant : participants) {
            double pay = (calcParticipantProductionPoints(participant) / product.getProductionCosts()) * (lastExpenses/stock) * (1 + profitMargin) * profitMargin;
            //Hire him if not "outbidded"
            if (pay > Util.getJobMarket(id).getParticipantPay().get(participants)) {
                //Not outbidded now this is the highest bidding company
                Util.getJobMarket(id).getParticipantPay().put(participant, pay);
                Util.getJobMarket(id).getParticipantCompany().put(participant, this);
                outbidded++;
            }
        }
        if(outbidded < HIRINGMAX) {
            hiringEvaluation -= EVALUATIONCHANGE;
        } else if(outbidded > HIRINGMAX) {
            hiringEvaluation += EVALUATIONCHANGE;
        }
    }
    public double evaluateParticipant(Participant participant) {
        double evaluation = 0;
        List<Double> valueOfTraits = participant.getPersonality().getValueOfTraits();
        for (int i = 0; i < participant.getPersonality().getValueOfTraits().size(); i++) {
            evaluation += Trait.values()[i].getMaxChange() * valueOfTraits.get(i);
        }
        return evaluation;
    }
    public double calculateProductionPoints() {
        double productionPoints = 0;
        for(int i = 0; i < jobs.size(); i++) {
            productionPoints += calcParticipantProductionPoints(jobs.get(i).getParticipant());
        }
        return productionPoints;
    }
    private double calcParticipantProductionPoints(Participant participant) {
        double productionPoints = 0;
        //Redo this calculation.
        for(int i = 0; i<participant.getPersonality().getValueOfTraits().size(); i++) {
            productionPoints += 100 + Trait.values()[i].getMaxChange() * participant.getPersonality().getValueOfTraits().get(i);
        }
        return productionPoints;
    }
    //Getter and Setter
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Item getProduct() {
        return product;
    }

    public void setProduct(Item product) {
        this.product = product;
    }
}
