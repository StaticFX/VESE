package de.vese.vese.simulation.participant;

import de.vese.vese.simulation.company.Company;

/*
    VESE - Job
    Version: 1.0.1
    Author: David
    Alias: Dawitschi
 */
public class Job {

    private Company company;
    private Participant participant;
    private double pay;

    public Job(Company company, Participant participant, double pay) {
        this.participant = participant;
        this.company = company;
        this.pay = pay;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
