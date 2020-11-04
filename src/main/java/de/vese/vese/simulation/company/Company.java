package de.vese.vese.simulation.company;

<<<<<<< HEAD:src/main/java/de/vese/vese/company/Company.java
import de.vese.vese.market.Item;
import de.vese.vese.market.Market;
import de.vese.vese.market.Offer;
import de.vese.vese.participant.Job;
import de.vese.vese.participant.Participant;
import de.vese.vese.simulation.participant.Trait;
=======
import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.market.Market;
import de.vese.vese.simulation.market.Offer;
import de.vese.vese.simulation.participant.Job;
>>>>>>> main:src/main/java/de/vese/vese/simulation/company/Company.java

import java.util.List;
/*
    VESE - Item
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
public class Company {

    private List<Job> jobs;
    private Item product;
    private int stock;
    public Company(List<Job> jobs, Item product, int stock) {
        this.jobs = jobs;
        this.product = product;
        this.stock = stock;
    }
    //Self-made functions
    public void makeTurnDecisions() {
        //decide how much to produce
        int amount = (int) (calculateProductionPoints()/product.getProductionCosts());
        //decide on a profit margin
    }
    public double calculateProductionPoints() {
        double productionPoints = 0;
        for(int i = 0; i < jobs.size(); i++) {
            productionPoints += calcParticipantProductionPoints(jobs.get(i).getParticipant());
        }
        return productionPoints;
    }

    private double calcParticipantProductionPoints(Participant participant) {
        double productionPoints = 0;
        //Redo this calculation.
        for(int i = 0; i<participant.getPersonality().getValueOfTraits().size(); i++) {
            productionPoints += 100 + Trait.values()[i].getMaxChange() * participant.getPersonality().getValueOfTraits().get(i);
        }
        return productionPoints;
    }

    public void makeOfferOnMarket(Market market, int amount, int price) {
        market.makeOffer(new Offer(product, price, amount));
    }
    //Getter and Setter
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Item getProduct() {
        return product;
    }

    public void setProduct(Item product) {
        this.product = product;
    }
}
