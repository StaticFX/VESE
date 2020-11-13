package de.vese.vese.simulation.utilities;

import de.vese.vese.simulation.company.Company;
import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.market.Market;
import de.vese.vese.simulation.market.Offer;
import de.vese.vese.simulation.participant.Need;
import de.vese.vese.simulation.participant.Needs;
import de.vese.vese.simulation.participant.Participant;
import de.vese.vese.simulation.participant.Personality;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public static Market getMarket(Item item) {
        return null;
    }
    public static void createItems(int amount) {
        for(int i = 0; i < amount; i++) {
            System.out.println("Enter Name of " + i + ". Item");
        }
    }
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
    public static List<Participant> getParticipants() {
        //remember Database stuff
        return null;
    }
    public static void createCompany(Item product,double profitMargin, double capital,int simulationID) {
        Company company = new Company(null, product,0,profitMargin,0, capital);
        //Remember to save them in the Database
    }
    public static List<Company> getCompanies() {
        //Remember Database blablabla
        return null;
    }
    public static void createMarket(Item item, int simulationID) {
        Market market = new Market(null,item);
        //Remember to save in the Database
    }
    public static List<Item> getItems(int simulationID) {
        return null;
    }
    public static double getCheapestPrice() {
        //Database stuff
        return 0.0;
    }
    public static List<Offer> getCheapestOffers() {
        //Database stuff
        return null;
    }
}
