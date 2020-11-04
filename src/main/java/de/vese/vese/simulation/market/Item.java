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
    public Item(Needs needsSatisfied) {
        this.needsSatisfied = needsSatisfied;
    }

    public List<Double> getNeedsSatisfied() {
        return needsSatisfied.getNeedValueList();
    }

    public void setNeedsSatisfied(Needs needsSatisfied) {
        this.needsSatisfied = needsSatisfied;
    }
}
