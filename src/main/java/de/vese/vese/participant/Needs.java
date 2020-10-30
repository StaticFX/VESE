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
    private List<Double> maxChangeList;

    public Needs(List<Double> needValueList, List<Double> maxChangeList) {
        this.maxChangeList = maxChangeList;
        this.needValueList = needValueList;

    }
    //Selfmade functions
    public void update(Boolean isItem, Personality personality){

    }
    //Getter and Setter

    public List<Double> getNeedValueList() {
        return needValueList;
    }

    public void setNeedValueList(List<Double> needValueList) {
        this.needValueList = needValueList;
    }

    public List<Double> getMaxChangeList() {
        return maxChangeList;
    }

    public void setMaxChangeList(List<Double> maxChangeList) {
        this.maxChangeList = maxChangeList;
    }
}
