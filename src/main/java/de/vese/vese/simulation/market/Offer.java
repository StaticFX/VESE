package de.vese.vese.simulation.market;
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
    public Offer(Item product, double price, int amount) {
        this.amount = amount;
        this.price = price;
        this.product = product;
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
