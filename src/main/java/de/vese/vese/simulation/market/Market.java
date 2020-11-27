package de.vese.vese.simulation.market;


import de.vese.vese.simulation.company.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * A place for Companies to trade with participants
 * Companies offer their products here for a price
 * Participants buy from the offers then
 *
 * @author David
 * @version 1.0.0
 */
/*
Offers have to be from lowest price to highest.
 */
public class Market {
    private List<Offer> offers;
    private Item tradingItem;

    /**
     *
     * @param offers List of all offers
     * @param tradingItem Item traded in this market
     */
    public Market(List<Offer> offers, Item tradingItem) {
        this.offers = offers;
        this.tradingItem = tradingItem;
    }
    //Self-Made functions

    /**
     * adds an offer to the market in the correct spot according to its price (lowest to highest)
     * @param offer the offer added
     */
    public void makeOffer(Offer offer) {
        if(offers.size() == 0) {
            offers.add(offer);
        } else {
            for (int i = 0; i < offers.size(); i++) {
                if (offer.getPrice() < offers.get(i).getPrice()) {
                    offers.add(i, offer);
                    break;
                }
            }
        }
    }

    /**
     * gives the Company the leftover stock back and then sets the offers to a new Arraylist
     */
    public void returnLeftovers() {
        for(Offer offer : offers) {
            offer.returnToCompany();
        }
        List<Offer> empty = new ArrayList<>();
        offers = empty;
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
