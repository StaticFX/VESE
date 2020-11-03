package de.vese.vese.participant;

import java.util.List;

/*
    VESE - Needs
    Version: 1.0.1
    Author: David
    Alias: Dawitschi
 */
/*
These are the needs of all Participants.
Their acceleration time is influenced by the Participants Personality.
They can be increased by buying Items.
They decrease for the normal person per turn with a Value of 100
If they are down to zero a Participants health decreases by a factor specific to the need which is at 0.
 */
public class Needs {
    private List<Double> needValueList;
    private double health;
    public Needs(List<Double> needValueList, double health) {
        this.needValueList = needValueList;
        this.health = health;
    }
    //Selfmade functions
    public void update(Boolean isItem, Personality personality){
        if(!isItem) {
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
