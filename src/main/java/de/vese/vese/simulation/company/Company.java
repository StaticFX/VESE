package de.vese.vese.simulation.company;

import de.vese.vese.simulation.market.Item;
import de.vese.vese.simulation.market.Market;
import de.vese.vese.simulation.market.Offer;
import de.vese.vese.simulation.participant.Job;

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
