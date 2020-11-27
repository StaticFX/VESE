package de.vese.vese.simulation;

import de.vese.vese.simulation.company.Company;
import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.market.Market;
import de.vese.vese.simulation.participant.Participant;
import de.vese.vese.simulation.util.Util;

import java.util.UUID;

/**
 * The Simulation from which all is managed
 *
 * @author David
 * @version 1.0.0
 */
public class Simulation {
    /**
     * STARTINGCAPITAL_PARTICIPANT is the starting capital of a participant
     * STARTINGPROFITMARGIN is the initial profit margin of a company
     * STARTINGCAPITAL_COMPANY is the starting capital of a company
     */
    private final double STARTINGCAPITAL_PARTICIPANT = 1000;
    private final double STARTINGPROFITMARGIN = 0.1;
    private final double STARTINGCAPITAL_COMPANY = 100000;

    private UUID id;

    /**
     * @param id the ID of the simulation
     */
    public Simulation(UUID id) {
        this.id = id;
    }

    /**
     * simulates one turn.
     * For more detailed information about how a turn gets simulated check the comments in the method
     */
    public void simulateTurn() {
        //Companies change Price
        //Companies produce
        //Participants get paid
        //Companies offer on Market
        for(Company company : Util.getCompanies()) {
            company.changeProfitMargin();
            company.produce();
            company.offerProduct();
        }
        //Participants buy Items
        //Participants update needs
        for(Participant participant : Util.getParticipants()) {
            participant.buyItems();
            participant.endTurn();
        }
        //Markets returns leftovers
        for(Market market : Util.getMarkets()) {
            market.returnLeftovers();
        }
        //Update company stats
        for(Company company : Util.getCompanies()) {
            company.payParticipants();
            company.updateStats(id);
        }
        //Update Jobmarket
        Util.getJobMarket(id).update();

    }

    /**
     * Initializes a new Simulation
     * @param amountOfParticipants amount of participants
     * @param amountOfCompaniesPerItem amount of companies per item
     * @param amountOfItems amount of items
     */
    public void initSimulation(int amountOfParticipants,int amountOfCompaniesPerItem, int amountOfItems) {
        //Generate Participants
        Util.createParticipants(amountOfParticipants, STARTINGCAPITAL_PARTICIPANT);
        //Let the user create the Items he wants
        Util.createItems(amountOfItems);
        //Create a Market for every Item
        for(Item item : Util.getItems(id)) {
            Util.createMarket(item, id);
        }
        //Create Companies
        for(Item item : Util.getItems(id)) {
            for (int i = 0; i < amountOfCompaniesPerItem; i++) {
                Util.createCompany(item, STARTINGPROFITMARGIN, STARTINGCAPITAL_COMPANY, id);
            }
        }
        //Create Jobmarket and add all Participants to it
        Util.createJobmarket();
        for (Participant participant : Util.getParticipants()) {
            Util.addPartJobmarket(participant);
        }

    }
}
