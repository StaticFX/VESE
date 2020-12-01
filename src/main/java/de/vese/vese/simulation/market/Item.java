package de.vese.vese.simulation.market;

import de.vese.vese.simulation.participant.Needs;

import java.util.List;

/**
 * An Item is a Object which satisfies the needs of participants and has some production costs
 *
 * @author David
 * @version 1.0.0
 */
public class Item {

    private Needs needsSatisfied;
    private double productionCosts;

    /**
     * @param needsSatisfied all needs satisfied from the Item
     * @param productionCosts the production cost for the Item
     */
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
