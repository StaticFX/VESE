package de.vese.vese.market;


import java.util.List;

/*
    VESE - Market
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
/*
Offers have to be from lowest price to highest.
 */
public class Market {
    private List<Offer> offers;
    private Item tradingItem;
    public Market(List<Offer> offers, Item tradingItem) {
        this.offers = offers;
        this.tradingItem = tradingItem;
    }
    //Self-Made functions
    public void makeOffer(Offer offer) {
        offers.add(offer);
    }
    //Getter and Setter


    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Item getTradingItem() {
        return tradingItem;
    }

    public void setTradingItem(Item tradingItem) {
        this.tradingItem = tradingItem;
    }
}
