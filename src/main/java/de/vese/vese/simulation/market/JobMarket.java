package de.vese.vese.simulation.market;

import de.vese.vese.simulation.company.Company;
import de.vese.vese.simulation.participant.Job;
import de.vese.vese.simulation.participant.Participant;

import java.util.HashMap;
import java.util.List;

/**
 * A special Market where all unemployed Participants are listed.
 * Companies bid for the unemployed if they want.
 *
 * @author David
 * @version 1.0.0
 */
public class JobMarket {
    private List<Participant> unemployed;
    private HashMap<Participant, Company> participantCompany;
    private HashMap<Participant, Double> participantPay;

    /**
     * @param unemployed List of all unemployed participants
     * @param participantCompany Company with the highest bid for every unemployed
     * @param participantPay highest bid for every unemployed
     */
    public JobMarket(List<Participant> unemployed, HashMap<Participant, Company> participantCompany, HashMap<Participant, Double> participantPay){
        this.unemployed = unemployed;
        this.participantCompany = participantCompany;
        this.participantPay = participantPay;
    }
    //Selfmade functions

    /**
     * updates the status of every participant
     *      -employs him if some company bid for him
     *      -removes participants if they are employed
     *      -resets the two Hashmaps
     */
    public void update() {
        for(Participant participant : unemployed) {
            if(participantCompany.get(participant) != null) {
                Job job = new Job(participantCompany.get(participant),participant,participantPay.get(participant));
                participant.setJob(job);
                List<Job> newjobs = participantCompany.get(participant).getJobs();
                newjobs.add(job);
                participantCompany.get(participant).setJobs(newjobs);
            }
            if(participant.getJob() != null) {
                unemployed.remove(participant);
            }
        }
        participantCompany = new HashMap<>();
        participantPay = new HashMap<>();
    }
    //Getter and Setter
    public HashMap<Participant, Company> getParticipantCompany() {
        return participantCompany;
    }

    public void setParticipantCompany(HashMap<Participant, Company> participantCompany) {
        this.participantCompany = participantCompany;
    }

    public HashMap<Participant, Double> getParticipantPay() {
        return participantPay;
    }

    public void setParticipantPay(HashMap<Participant, Double> participantPay) {
        this.participantPay = participantPay;
    }

    public List<Participant> getUnemployed() {
        return unemployed;
    }

    public void setUnemployed(List<Participant> unemployed) {
        this.unemployed = unemployed;
    }
}
