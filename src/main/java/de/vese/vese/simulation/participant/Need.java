package de.vese.vese.simulation.participant;

/**
 * An Need is something a participant wants/needs.
 * If he doesn't have enough of it his health decreases.
 */
public enum Need {
    FOOD(0, 50, 50),
    HYGIENE(1, 50, 20),
    SHELTER(2, 50, 35);



    private final int index;
    private final int maxChange;
    private final double damage;

    /**
     * @param index Index of the Need
     * @param maxChange The maximum change of the need per turn for a participant)
     * @param damage The amount of damage a participant gets if he cant fulfill the need
     */
    Need(int index, int maxChange, double damage) {
        this.index = index;
        this.maxChange = maxChange;
        this.damage = damage;
    }

    //Getter
    public double getDamage() {
        return damage;
    }

    public int getIndex() {
        return index;
    }

    public int getMaxChange() {
        return maxChange;
    }
}
