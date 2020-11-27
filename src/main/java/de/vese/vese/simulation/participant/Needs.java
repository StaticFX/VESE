package de.vese.vese.simulation.participant;

import java.util.List;

/**
 * The Value of every need and a participants health is contained in this.
 *
 * @author David
 * @version 1.0.0
 */
public class Needs {

    private List<Double> needValueList;
    private double health;

    /**
     * @param needValueList Value of every need in order of the needs
     * @param health health of the participant
     */
    public Needs(List<Double> needValueList, double health) {
        this.needValueList = needValueList;
        this.health = health;
    }

    //Selfmade functions

    /**
     * Decreases every need proportional to its personality
     * Deals Damage to the participant if he hasn't fulfilled a need and highers the needs Prioritization.
     * @param personality the personality of the participant
     */
    public void update(Personality personality){
        for(int i = 0; i < needValueList.size(); i++) {
            double need = needValueList.get(i);
            need -= (100 + personality.getImportanceOfNeed().get(i) * Need.values()[i].getMaxChange());
            if (need <= 0) {
                //update health
                health -= Need.values()[i].getDamage();
                //prioritise more in future
                personality.getPriorizationValues().set(i,personality.getPriorizationValues().get(i) + 10);
                //caps the highest Value for the prioritization to 100
                if (personality.getPriorizationValues().get(i) > 100) {
                    double highest = personality.getPriorizationValues().get(i);
                    for(int u = 0; u < personality.getPriorizationValues().size();u++) {
                        personality.getPriorizationValues().set(u,personality.getPriorizationValues().get(u)/highest * 100);
                    }
                }
            }
            needValueList.set(i,need);
        }
    }

    //Getter and Setter
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public List<Double> getNeedValueList() {
        return needValueList;
    }

    public void setNeedValueList(List<Double> needValueList) {
        this.needValueList = needValueList;
    }
}
