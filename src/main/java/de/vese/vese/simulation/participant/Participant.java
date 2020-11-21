package de.vese.vese.simulation.participant;
import de.vese.vese.simulation.market.Offer;
import de.vese.vese.simulation.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A Participant simulates a real human in the economy.
 * It has needs, a Personality, a cash reserve and a Job.
 *
 * @author David
 * @version 1.0.0
 */
public class Participant {

    private Personality personality;
    private double capital;
    private Needs needs;
    private Job job;
    private boolean alive;

    /**
     * @param personality The personality of the participant
     * @param capital the participants money
     * @param needs the needs of the participant
     * @param job the job of the participant
     * @param alive if the participant is alive
     */
    public Participant(Personality personality, double capital, Needs needs, Job job, boolean alive) {
        this.capital = capital;
        this.job = job;
        this.needs = needs;
        this.personality = personality;
        this.alive = alive;
    }

    //Self-Made functions

    /**
     * Randomizes a participants personality
     */
    public void randomizePersonality() {
        if (personality == null) {
            Random r = new Random();
            List<Double> importanceOfNeed = new ArrayList<>();
            List<Double> priorizationValues = new ArrayList<>();
            for(int i = 0; i < Need.values().length; i++) {
                importanceOfNeed.add( -1 + 2 * r.nextDouble());
                priorizationValues.add(50.0);
            }
            List<Double> valueOfTraits = new ArrayList<>();
            for (int i = 0; i < Trait.values().length;i++) {
                valueOfTraits.add(-1 + 2 * r.nextDouble());
            }
            personality = new Personality(importanceOfNeed,priorizationValues,valueOfTraits);
        } else {
            personality.randomize();
        }
    }

    /**
     * Lets a participant buy the highest evaluated Item as long as he wants to buy and
     * has the money to buy something.
     */
    public void buyItems() {
        //While you have enough money to buy something AND want to buy something
        boolean isWillingToBuy = true;
        while((capital >= Util.getCheapestPrice()) && isWillingToBuy) {
            //go through all markets and evaluate them then buy if you want to
            List<Offer> cheapestOffers = Util.getCheapestOffers();
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

    /**
     * Evaluates an offer via a formula:
     *
     * gets = how much of the need he gets
     * wants = how much he needs the need
     * prioritization = how much the need is prioritized
     *
     * evaluation = (sum(gets*wants*prioritization) for all needs) / price
     * @param offer the offer to evaluate
     * @return the evaluation
     */
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

    /**
     * Buys an certain amount from an offer and adds the needs satisfied to the participants needs.
     * @param offer the offer to buy from
     * @param amount the amount to buy
     */
    public void buy(Offer offer, int amount) {
        double price = offer.getPrice();
        offer.setAmount(offer.getAmount() - amount);
        capital -= price*amount;
        for(int i = 0;i < offer.getProduct().getNeedsSatisfied().size(); i++) {
            double needOfProduct = offer.getProduct().getNeedsSatisfied().get(i);
            double needOfParticipant = needs.getNeedValueList().get(i);
            needs.getNeedValueList().set(i, needOfParticipant + needOfProduct);
        }
    }

    /**
     * updates the needs of the participant
     */
    public void endTurn() {
        needs.update( personality);
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
