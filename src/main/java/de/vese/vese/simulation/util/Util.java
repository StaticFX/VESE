package de.vese.vese.simulation.util;

import de.vese.vese.simulation.company.Company;
import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.market.JobMarket;
import de.vese.vese.simulation.market.Market;
import de.vese.vese.simulation.market.Offer;
import de.vese.vese.simulation.participant.Need;
import de.vese.vese.simulation.participant.Needs;
import de.vese.vese.simulation.participant.Participant;
import de.vese.vese.simulation.participant.Personality;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A class to access the Database (might be replaced later)
 *
 * @author David
 * @version 1.0.0
 */
public class Util {

    /**
     * @param simulationID the ID of the Simulation of the needed Jobmarket
     * @return Jobmarket
     */
    public static JobMarket getJobMarket(UUID simulationID) {
        return null;
    }

    /**
     * @param item the item of the market
     * @return the market
     */
    public static Market getMarket(Item item) {
        return null;
    }

    /**
     * @return all the markets
     */
    public static List<Market> getMarkets() {
        return null;
    }

    /**
     * Creates items
     * @param amount of Items to create
     */
    public static void createItems(int amount) {
        for(int i = 0; i < amount; i++) {
            //WIP
        }
    }

    /**
     * creates Participants
     * @param amount amount of participants to create
     * @param startingcapital stratingCapital of the participants
     */
    public static void createParticipants(int amount, double startingcapital) {
        List<Double> emptyList = new ArrayList<>();
        Personality personality = new Personality(emptyList, emptyList, emptyList);
        List<Double> listNeeds = new ArrayList<>();
        for(Need need : Need.values()) {
            listNeeds.add(100.0);
        }
        Needs needs= new Needs(listNeeds,100);
        for(int i = 1;i <= amount; i++) {
            Participant participant = new Participant(personality,startingcapital, needs,null,true);
            participant.randomizePersonality();
        }
    }

    /**
     * @return all Participants
     */
    public static List<Participant> getParticipants() {
        //remember Database stuff
        return null;
    }

    /**
     * creates a company
     * @param product product of the company
     * @param profitMargin initial profit margin
     * @param capital startingcapital
     * @param simulationID the simulation
     */
    public static void createCompany(Item product, double profitMargin, double capital, UUID simulationID) {
        Company company = new Company(null, product,0,profitMargin,0, capital,0);
        //Remember to save them in the Database
    }

    /**
     * @return all companies
     */
    public static List<Company> getCompanies() {
        //Remember Database blablabla
        return null;
    }

    /**
     * creates a market
     * @param item trading item
     * @param simulationID Simulation
     */
    public static void createMarket(Item item, UUID simulationID) {
        Market market = new Market(null,item);
        //Remember to save in the Database
    }

    /**
     * @param simulationID simulation
     * @return all the items
     */
    public static List<Item> getItems(UUID simulationID) {
        return null;
    }

    /**
     * @return price of the cheapest item
     */
    public static double getCheapestPrice() {
        //Database stuff
        return 0.0;
    }

    /**
     * @return offer with the lowest price
     */
    public static List<Offer> getCheapestOffers() {
        //Database stuff
        return null;
    }
}
