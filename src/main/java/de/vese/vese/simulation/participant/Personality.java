package de.vese.vese.simulation.participant;
/*
    VESE - Personality
    Version: 1.0.1
    Author: David
    Alias: Dawitschi
 */

import java.util.List;
import java.util.Random;

/*
    All measured from -100 to 100 (meant as %) except priorizationValues (measured from 0 to 100)
    These influence the Needs.
     */

/**
 * The personality of a participant determines the following:
 *          -how much of each need the participant needs (needs less than average, more than average)
 *                 * measured in percents from -1 to 1.
 *          -how much each needs gets prioritized
 *                 * measured from 0 to 100
 *          -how good a participant is in a specific trait
 *                 * measured in percents from -1 to 1.
 * @author David
 * @version 1.0.0
 */
public class Personality {

    private  List<Double> importanceOfNeed;
    private List<Double> priorizationValues;
    private List<Double> valueOfTraits;

    /**
     * @param importanceOfNeed how much of each need the participant needs
     * @param priorizationValues how much each needs gets prioritized
     * @param valueOfTraits how good a participant is in a specific trait
     */
    public Personality(List<Double> importanceOfNeed, List<Double> priorizationValues, List<Double> valueOfTraits) {
        this.importanceOfNeed = importanceOfNeed;
        this.priorizationValues = priorizationValues;
        this.valueOfTraits = valueOfTraits;

    }

    /**
     * randomizes importanceOfNeeds and valueOfTraits.
     * priorizationValues gets set to 50 for all.
     */
    public void randomize() {
        Random r = new Random();
        for(int i = 0; i < Need.values().length; i++) {
            importanceOfNeed.set(i, -1 + 2 * r.nextDouble());
            priorizationValues.set(i, 50.0);
        }
        for (int i = 0; i < Trait.values().length;i++) {
            valueOfTraits.set(i,-1 + 2 * r.nextDouble());
        }
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
