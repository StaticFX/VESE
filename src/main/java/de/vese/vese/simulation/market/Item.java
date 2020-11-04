package de.vese.vese.simulation.market;

import de.vese.vese.simulation.participant.Needs;

import java.util.List;

/*
    VESE - Item
    Version: 1.0.0
    Author: David
    Alias: Dawitschi
 */
public class Item {

    private Needs needsSatisfied;
    private double productionCosts;
    public Item(Needs needsSatisfied, double productionCosts) {
        this.needsSatisfied = needsSatisfied;
        this.productionCosts = productionCosts;
    }

    public double getProductionCosts() {
        return productionCosts;
    }

    public void setProductionCosts(double productionCosts) {
        this.productionCosts = productionCosts;
    }

    public List<Double> getNeedsSatisfied() {
        return needsSatisfied.getNeedValueList();
    }

    public void setNeedsSatisfied(Needs needsSatisfied) {
        this.needsSatisfied = needsSatisfied;
    }
}
