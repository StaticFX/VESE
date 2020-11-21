package de.vese.vese.simulation.market;

import de.vese.vese.simulation.company.Company;

/**
 * An offer is a certain amount of an item offered in an market to a certain price by a company
 *
 * @author David
 * @version 1.0.0
 */
public class Offer {
    private Item product;
    private double price;
    private  int amount;
    private Company company;

    /**
     * @param product the product offered
     * @param price the price for one product
     * @param amount the amount offered
     * @param company the company offering the product
     */
    public Offer(Item product, double price, int amount, Company company) {
        this.amount = amount;
        this.price = price;
        this.product = product;
        this.company = company;
    }

    /**
     * Gives the company back all the amount contained in the offer
     */
    public void returnToCompany() {
        company.setStock(company.getStock() + amount);
    }

    //Getter and Setter

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
