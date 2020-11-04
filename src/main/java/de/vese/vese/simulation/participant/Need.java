package de.vese.vese.simulation.participant;

public enum Need {
    FOOD(0, 50, 50),
    HYGIENE(1, 50, 20),
    SHELTER(2, 50, 35);



    private final int index;
    private final int maxChange;
    private final double damage;
    Need(int index, int maxChange, double damage) {
        this.index = index;
        this.maxChange = maxChange;
        this.damage = damage;
    }

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
