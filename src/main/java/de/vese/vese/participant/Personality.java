package de.vese.vese.participant;
/*
    VESE - Personality
    Version: 1.0.1
    Author: David
    Alias: Dawitschi
 */

import java.util.List;

/*
    All measured from -100 to 100 (meant as %) except priorizationValues
    These influence the Needs.
     */
public class Personality {
    private  List<Double> importanceOfNeed;
    private List<Double> priorizationValues;
    private List<Double> valueOfTraits;
    public Personality(List<Double> importanceOfNeed, List<Double> priorizationValues, List<Double> valueOfTraits) {
        this.importanceOfNeed = importanceOfNeed;
        this.priorizationValues = priorizationValues;
        this.valueOfTraits = valueOfTraits;

    }
    //Getter and Setter

    public List<Double> getValueOfTraits() {
        return valueOfTraits;
    }

    public void setValueOfTraits(List<Double> valueOfTraits) {
        this.valueOfTraits = valueOfTraits;
    }

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
