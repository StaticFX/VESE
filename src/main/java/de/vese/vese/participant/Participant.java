package de.vese.vese.participant;

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

import de.vese.vese.market.Item;
import de.vese.vese.market.Market;
import de.vese.vese.market.Offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        //go through all markets and evaluate them then buy if you want to

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

    }
    public void endTurn() {
        needs.update(false, personality);
        capital += job.getPay();
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
