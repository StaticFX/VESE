package de.vese.vese.participant;
/*
    VESE - Personality
    Version: 1.0.1
    Author: David
    Alias: Dawitschi
 */

import java.util.HashMap;
import java.util.List;

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
    private  List<Double> importanceOfNeed;
    private List<Double> priorizationValues;
    public Personality(List<Double> importanceOfNeed, List<Double> priorizationValues) {
        this.importanceOfNeed = importanceOfNeed;
        this.priorizationValues = priorizationValues;

    }
    //Getter and Setter

    public List<Double> getImportanceOfNeed() {
        return importanceOfNeed;
    }

    public void setImportanceOfNeed(List<Double> importanceOfNeed) {
        this.importanceOfNeed = importanceOfNeed;
    }

    public List<Double> getPriorizationValues() {
        return priorizationValues;
    }

    public void setPriorizationValues(List<Double> priorizationValues) {
        this.priorizationValues = priorizationValues;
    }
}
