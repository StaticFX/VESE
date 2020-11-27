package de.vese.vese.simulation.participant;

/**
 * A Trait is a part of the personality which influences the productivity
 * in a job.
 *
 * Maxchange measured from 100.
 */
public enum Trait {
    IQ(0,50),
    EQ(1,50);


    private final int index;
    private final int maxChange;

    /**
     * @param index index of the Trait
     * @param maxChange maximum change from 100
     */
    Trait(int index, int maxChange) {
        this.index = index;
        this.maxChange = maxChange;
    }

    //Getter and Setter
    public int getIndex() {
        return index;
    }

    public int getMaxChange() {
        return maxChange;
    }
}
