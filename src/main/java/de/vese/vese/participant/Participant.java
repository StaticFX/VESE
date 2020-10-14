package de.vese.vese.participant;

/*
    VESE - Participant
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */

/*
A participant is like a real life person it has a personality, capital, needs and a job.
Also it can trade stocks and buy items from the market.
 */

import java.beans.PersistenceDelegate;

public class Participant {
    private Personality personality;
    private double capital;
    private Needs needs;
    private Job job;
    public Participant(Personality personality, double capital, Needs needs, Job job) {
        this.capital = capital;
        this.job = job;
        this.needs = needs;
        this.personality = personality;
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
