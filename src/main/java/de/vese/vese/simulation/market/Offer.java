package de.vese.vese.simulation.market;

import de.vese.vese.simulation.company.Company;

/*
    VESE - Offer
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
public class Offer {
    private Item product;
    private double price;
    private  int amount;
    private Company company;
    public Offer(Item product, double price, int amount, Company company) {
        this.amount = amount;
        this.price = price;
        this.product = product;
        this.company = company;
    }

    public void returnToCompany() {
        company.setStock(company.getStock() + amount);

    }

    public Item getProduct() {
        return product;
    }

    public void setProduct(Item product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
