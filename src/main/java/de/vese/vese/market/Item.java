package de.vese.vese.market;

import de.vese.vese.participant.Needs;

import java.util.List;
import java.util.Vector;

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
