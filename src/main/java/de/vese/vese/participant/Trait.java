package de.vese.vese.participant;

public enum Trait {
    IQ(0,50),
    EQ(1,50);


    private final int index;
    private final int maxChange;
    Trait(int index, int maxChange) {
        this.index = index;
        this.maxChange = maxChange;
    }

    public int getIndex() {
        return index;
    }

    public int getMaxChange() {
        return maxChange;
    }
}
