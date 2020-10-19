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
        
    }
    public void endTurn() {
        needs.update(personality);
        alive = needs.isAlive();
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
