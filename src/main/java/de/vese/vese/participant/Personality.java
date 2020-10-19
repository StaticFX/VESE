package de.vese.vese.participant;
/*
    VESE - Personality
    Version: 1.0.1
    Author: David
    Alias: Dawitschi
 */

/*
    This determines the Personality trades of a participant such as:
    -importanceOfHygiene
    -hungriness
    -sleepiness
    -boredomTolerance
    -importanceOfPrestige
    -importanceOfSecurity
    -importanceOfHealth
    All measured from -100 to 100 (meant as %)
    These influence the Needs.
     */
public class Personality {
    private int importanceOfHygiene;
    private int importanceOfHealth;
    private int importanceOfPrestige;
    private int importanceOfSecurity;
    private int hungriness;
    private int sleepiness;
    private int boredomTolerance;

    public Personality(int importanceOfHygiene, int importanceOfPrestige, int importanceOfSecurity, int importanceOfHealth,
                       int hungriness, int sleepiness, int boredomTolerance) {

        this.boredomTolerance = boredomTolerance;
        this.hungriness = hungriness;
        this.importanceOfHealth = importanceOfHealth;
        this.importanceOfHygiene = importanceOfHygiene;
        this.importanceOfPrestige = importanceOfPrestige;
        this.importanceOfSecurity = importanceOfSecurity;
        this.sleepiness = sleepiness;
    }

    public int getImportanceOfHygiene() {
        return importanceOfHygiene;
    }

    public void setImportanceOfHygiene(int importanceOfHygiene) {
        this.importanceOfHygiene = importanceOfHygiene;
    }

    public int getImportanceOfHealth() {
        return importanceOfHealth;
    }

    public void setImportanceOfHealth(int importanceOfHealth) {
        this.importanceOfHealth = importanceOfHealth;
    }

    public int getImportanceOfPrestige() {
        return importanceOfPrestige;
    }

    public void setImportanceOfPrestige(int importanceOfPrestige) {
        this.importanceOfPrestige = importanceOfPrestige;
    }

    public int getImportanceOfSecurity() {
        return importanceOfSecurity;
    }

    public void setImportanceOfSecurity(int importanceOfSecurity) {
        this.importanceOfSecurity = importanceOfSecurity;
    }

    public int getHungriness() {
        return hungriness;
    }

    public void setHungriness(int hungriness) {
        this.hungriness = hungriness;
    }

    public int getSleepiness() {
        return sleepiness;
    }

    public void setSleepiness(int sleepiness) {
        this.sleepiness = sleepiness;
    }

    public int getBoredomTolerance() {
        return boredomTolerance;
    }

    public void setBoredomTolerance(int boredomTolerance) {
        this.boredomTolerance = boredomTolerance;
    }
}
