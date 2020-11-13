package de.vese.vese.simulation.company;

import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.market.Market;
import de.vese.vese.simulation.market.Offer;
import de.vese.vese.simulation.participant.Job;
import de.vese.vese.simulation.participant.Participant;
import de.vese.vese.simulation.participant.Trait;
import de.vese.vese.simulation.utilities.Utilities;

import java.util.List;
/*
    VESE - Item
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
public class Company {

    private final double PROFITMARGINCHANGE = 0.005;
    private final double DOWNSIZINGPROFITMARGIN = 0.01;

    private List<Job> jobs;
    private Item product;
    private int stock;
    private double lastExpenses;
    private double capital;
    private double profitMargin;
    public Company(List<Job> jobs, Item product, int stock, double profitMargin, double lastExpenses, double capital) {
        this.jobs = jobs;
        this.capital = capital;
        this.product = product;
        this.stock = stock;
        this.profitMargin = profitMargin;
        this.lastExpenses = lastExpenses;
    }
    //Self-made functions
    public void makeTurnDecisions() {
        //decide on a profit margin
        changeProfitMargin();
        //calculate how much was produced
        int amountProduced = (int) (calculateProductionPoints()/product.getProductionCosts());
        stock += amountProduced;
        // Set price and make offer on market
        double price = (lastExpenses/amountProduced) * (1 + profitMargin);
        offerProduct();
        // Pay your Participants
        payParticipants();
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
        Market market = Utilities.getMarket(product);
        double prize = (lastExpenses/stock) * (1 + profitMargin);
        market.makeOffer(new Offer(product, prize, stock, this));
        stock = 0;
    }
    public void changeProfitMargin() {
        if (stock > 0) {
            //If not everything was sold lower profit margin
            if (profitMargin < DOWNSIZINGPROFITMARGIN) {
                //If profitmargin lower than a certain point then downsize (fire Participants)
                Participant worstParticipant = jobs.get(0).getParticipant();
                double worstProductionCostRatio = 0;
                for (int i = 0; i < jobs.size(); i++) {
                    double productionCostRatio = calcParticipantProductionPoints(jobs.get(i).getParticipant())/jobs.get(i).getPay();
                    if (worstProductionCostRatio == 0 || productionCostRatio < worstProductionCostRatio) {
                        worstProductionCostRatio = productionCostRatio;
                        worstParticipant = jobs.get(i).getParticipant();
                    }
                }
                fireParticipant(worstParticipant);
            } else {
                //Else just lower the Profitmargin a bit
                profitMargin -= PROFITMARGINCHANGE;
            }
        } else {
            //Higher the profit margin (since everything was sold)
            profitMargin += PROFITMARGINCHANGE;
        }
    }
    public void fireParticipant(Participant participant) {
        jobs.remove(participant.getJob());
        participant.setJob(null);
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
