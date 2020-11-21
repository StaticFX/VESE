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

/**
 * Object represents a Company in Simulation
 * Company produces Items, sells them
 * Similar to a real Company
 *
 * @author David
 * @version 1.0.0
 */
public class Company {

    /**
     * PROFITMARGINCHANGE is the value the Company adapts its profit margin with.
     * Changes profit margin if not all is sold/all is sold.
     * DOWNSIZINGPROFITMARGIN the profit margin at which the Company begins firing Participants.
     * EXPANDPROFITMARGIN the profit margin at which the Company begins hiring Participants.
     * HIRINGMAX Amount of Participants the Company wants to send a Job offer to at max
     * EVALUATIONCHANGE is the value the Company adapts its required evaluation of a Participant with.
     * Changes required evaluation if not enough / too many Participants were send a Job offer to.
     * SALARYFRACTION is the fraction of the profit a participant produces it gets offered as a salary
     */
    private final double PROFITMARGINCHANGE = 0.005;
    private final double DOWNSIZINGPROFITMARGIN = 0.03;
    private final double EXPANDPROFITMARGIN = 0.15;
    private final int HIRINGMAX = 3;
    private final double EVALUATIONCHANGE = 5;
    private final double SALARYFRACTION = 0.3;


    private List<Job> jobs;
    private Item product;
    private int stock;
    private double lastExpenses;
    private double capital;
    private double profitMargin;
    private double hiringEvaluation;

    /**
     *
     * @param jobs saves all the Employees the Company has with Info about salary etc.
     * @param product is the Item the Company sells
     * @param stock is the amount of product the Company currently has
     * @param profitMargin the current profit margin the company charges
     * @param lastExpenses the Expenses of the last turn
     * @param capital the money the Company currently has
     * @param hiringEvaluation the Evaluation a Participant needs to get a Job offer
     */
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

    /**
     * updates: lastExpenses(adds (does not reset lastExpenses) Costs like WIP)
     * Also:    hires/fires Participants
     * @param id the ID of the Simulation the Company is in
     */
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

    /**
     * Calculates the amount produced and adds it to the stock
     */
    public void produce() {
        stock += (int) (calculateProductionPoints()/product.getProductionCosts());
    }

    /**
     * Tested
     *
     * Pays every Participant, resets last expenses and adds the salary to it.
     */
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

    /**
     * Offers all items in the stock to the market, calculates price
     * Price = (expenses per Item) * (1 + profit margin)
     */
    public void offerProduct() {
        Market market = Util.getMarket(product);
        double prize = (lastExpenses/stock) * (1 + profitMargin);
        market.makeOffer(new Offer(product, prize, stock, this));
        stock = 0;
    }

    /**
     * Tested
     *
     * lowers the profit margin if not all was sold
     * highers the profit margin if all was sold
     */
    public void changeProfitMargin() {
        if (stock > 0) {
            //Too much leftover ergo lower the profitmargin
            profitMargin -= PROFITMARGINCHANGE;
        } else {
            //Higher the profit margin (since everything was sold)
            profitMargin += PROFITMARGINCHANGE;
        }
    }

    /**
     * Tested
     *
     * Goes through all employed Participants and gets the worst participant.
     * Worst participant is the Participant with the worst AmountProduced/Pay ratio
     * @return worst Participant
     */
    public Participant getWorstParticipant() {
        Participant worstParticipant = jobs.get(0).getParticipant();
        double worstProductionCostRatio = 1000000000;
        for (int i = 0; i < jobs.size(); i++) {
            double productionCostRatio = calcParticipantProductionPoints(jobs.get(i).getParticipant())/jobs.get(i).getPay();
            if (productionCostRatio < worstProductionCostRatio) {
                worstProductionCostRatio = productionCostRatio;
                worstParticipant = jobs.get(i).getParticipant();
            }
        }
        return worstParticipant;
    }

    /**
     * fires a participant
     * @param participant participant to fire
     */
    public void fireParticipant(Participant participant) {
        jobs.remove(participant.getJob());
        participant.setJob(null);
    }

    /**
     * goes through all unemployed participants and gives a bid on the ones meeting the requirements
     * (in terms of salary offered)
     * Salary = ItemsProduced * IncomePerItem * SalaryFraction
     * Adapts its requirements for an participants if too many bits are made
     * @param id ID of the Simulation the Company is in
     */
    public void hireParticipant(UUID id) {
        //Go through all unemployed Participants and offer the ones above a certain level a job with a salary
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
            double pay = (calcParticipantProductionPoints(participant) / product.getProductionCosts()) * (lastExpenses/stock) * (profitMargin) * SALARYFRACTION;
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

    /**
     * Tested
     *
     * Evaluates a Participant based on its Traits
     * @param participant Participant be evaluated
     * @return the Evaluation
     */
    public double evaluateParticipant(Participant participant) {
        double evaluation = 0;
        List<Double> valueOfTraits = participant.getPersonality().getValueOfTraits();
        for (int i = 0; i < participant.getPersonality().getValueOfTraits().size(); i++) {
            evaluation += Trait.values()[i].getMaxChange() * valueOfTraits.get(i);
        }
        return evaluation;
    }

    /**
     * Calculates the ProductionPoints produced by all Participants
     * @return the calculated ProductionPoints
     */
    public double calculateProductionPoints() {
        double productionPoints = 0;
        for(int i = 0; i < jobs.size(); i++) {
            productionPoints += calcParticipantProductionPoints(jobs.get(i).getParticipant());
        }
        return productionPoints;
    }

    /**
     * Tested
     *
     * Calculates the ProductionPoints produced by one Participant
     * @param participant Participant to calc ProductionPoints to
     * @return Productionpoints
     */
    public double calcParticipantProductionPoints(Participant participant) {
        double productionPoints = 0;
        //Redo this calculation.
        for(int i = 0; i<participant.getPersonality().getValueOfTraits().size(); i++) {
            productionPoints += 100 + Trait.values()[i].getMaxChange() * participant.getPersonality().getValueOfTraits().get(i);
        }
        return productionPoints;
    }
    //Getter and Setter

    public double getLastExpenses() {
        return lastExpenses;
    }

    public void setLastExpenses(double lastExpenses) {
        this.lastExpenses = lastExpenses;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getHiringEvaluation() {
        return hiringEvaluation;
    }

    public void setHiringEvaluation(double hiringEvaluation) {
        this.hiringEvaluation = hiringEvaluation;
    }

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
