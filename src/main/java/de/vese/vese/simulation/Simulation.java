package de.vese.vese.simulation;

import de.vese.vese.simulation.company.Company;
import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.participant.Participant;
import de.vese.vese.simulation.utilities.Utilities;


public class Simulation {
    private final double STARTINGCAPITAL_PARTICIPANT = 1000;
    private final double STARTINGPROFITMARGIN = 0.1;
    private final double STARTINGCAPITAL_COMPANY = 100000;

    private int id;

    public Simulation(int id) {
        this.id = id;
    }

    public void simulateTurn() {
        //Companies change Price
        //Companies produce
        //Participants get paid
        //Companies offer on Market
        for(Company company : Utilities.getCompanies()) {
            company.changeProfitMargin();
            company.produce();
            company.payParticipants();
            company.offerProduct();
        }
        //Participants buy Items
        //Participants update needs
        for(Participant participant : Utilities.getParticipants()) {
            participant.buyItems();
            participant.endTurn();
        }
        //Update company stats

    }
    public void initSimulation(int amountOfParticipants,int amountOfCompaniesPerItem, int amountOfItems) {
        //Generate Participants
        Utilities.createParticipants(amountOfParticipants, STARTINGCAPITAL_PARTICIPANT);
        //Let the user create the Items he wants
        Utilities.createItems(amountOfItems);
        //Create a Market for every Item
        for(Item item : Utilities.getItems(id)) {
            Utilities.createMarket(item, id);
        }
        //Create Companies
        for(Item item : Utilities.getItems(id)) {
            for (int i = 0; i < amountOfCompaniesPerItem; i++) {
                Utilities.createCompany(item, STARTINGPROFITMARGIN, STARTINGCAPITAL_COMPANY, id);
            }
        }
    }
}
