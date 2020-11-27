package de.vese.vese.simulation.participant;

import de.vese.vese.simulation.company.Company;

/**
 * A job is a contract between a company and a participant and a company.
 * Participant works for company and gets paid for that.
 *
 * @author David
 * @version 1.0.0
 */
public class Job {

    private Company company;
    private Participant participant;
    private double pay;

    /**
     * @param company The company
     * @param participant The participant
     * @param pay the pay of the Participant
     */
    public Job(Company company, Participant participant, double pay) {
        this.participant = participant;
        this.company = company;
        this.pay = pay;
    }

    //Getter and Setter
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
