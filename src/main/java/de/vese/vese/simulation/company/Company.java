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

    private List<Job> jobs;
    private Item product;
    private int stock;
    private double lastExpenses;
    private double lastProfitMargin;
    public Company(List<Job> jobs, Item product, int stock, double lastProfitMargin, double lastExpenses) {
        this.jobs = jobs;
        this.product = product;
        this.stock = stock;
        this.lastProfitMargin = lastProfitMargin;
        this.lastExpenses = lastExpenses;
    }
    //Self-made functions
    public void makeTurnDecisions() {
        //decide how much to produce
        int amountProduced = (int) (calculateProductionPoints()/product.getProductionCosts());
        //decide on a profit margin
        if (stock > 0) {
            changeProfitMargin(false);
        } else {
            changeProfitMargin(true);
        }
        // Set price and make offer on market
        double price = (lastExpenses/amountProduced) * (1 + lastProfitMargin);
        //Getting fitting market and make the offer
        Market market = Utilities.getMarket(product);
        market.makeOffer(new Offer(product, price, amountProduced, this));
    }

    public void changeProfitMargin(boolean higher) {

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
