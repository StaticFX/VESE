package de.vese.vese.simulation.participant;

/*
    VESE - Participant
    Version: 1.0.1
    Author: David
    Alias: Dawitschi
 */

/*
A participant is like a real life person it has a personality, capital, needs and a job.
Also it can trade stocks and buy items from the market.
 */

import de.vese.vese.db.MarketDAO;
import de.vese.vese.simulation.market.Offer;

import java.util.List;

public class Participant {
    private Personality personality;
    private double capital;
    private Needs needs;
    private Job job;
    private boolean alive;
    public Participant(Personality personality, double capital, Needs needs, Job job, boolean alive) {
        this.capital = capital;
        this.job = job;
        this.needs = needs;
        this.personality = personality;
        this.alive = alive;
    }
    //Self-Made functions
    public void buyItems() {
        //While you have enough money to buy something AND want to buy something
        boolean isWillingToBuy = true;
        while((capital >= MarketDAO.getCheapestPrice()) && isWillingToBuy) {
            //go through all markets and evaluate them then buy if you want to
            List<Offer> cheapestOffers = MarketDAO.getCheapestOffers();
            double bestOfferEvaluation = 0;
            Offer bestOffer = null;
            for (Offer offer : cheapestOffers) {
                if (evaluateOffer(offer) > bestOfferEvaluation) {
                    bestOffer = offer;
                    bestOfferEvaluation = evaluateOffer(offer);
                }
            }
            buy(bestOffer, 1);
        }
    }

    public double evaluateOffer(Offer offer) {
        //Get the gets, wants, prioritization values in form of lists
        List<Double> gets = offer.getProduct().getNeedsSatisfied();
        List<Double> wants = needs.getNeedValueList();
        List<Double> prioritizationValues = personality.getPriorizationValues();
        //Evaluating Item
        double evaluation = 0;
        for (int i = 0; i < gets.size(); i++) {
            evaluation += (gets.get(i) * wants.get(i) * prioritizationValues.get(i)) / offer.getPrice();
        }
        return evaluation;
    }

    public void buy(Offer offer, int amount) {
        double price = offer.getPrice();
        offer.setAmount(offer.getAmount() - amount);
        capital -= price;
        for(int i = 0;i < offer.getProduct().getNeedsSatisfied().size(); i++) {
            double needOfProduct = offer.getProduct().getNeedsSatisfied().get(i);
            double needOfParticipant = needs.getNeedValueList().get(i);
            needs.getNeedValueList().set(i, needOfParticipant + needOfProduct);
        }
    }
    public void endTurn() {
        needs.update(false, personality);
    }
    //Getter and Setter

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Needs getNeeds() {
        return needs;
    }

    public void setNeeds(Needs needs) {
        this.needs = needs;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
