package de.vese.vese.participant;
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
    public final double MAXFOODCHANGE = 75;
    public final double MAXSLEEPINESSCHANGE = 50;
    public final double MAXHYGINECHANGE = 25;
    public final double MAXFUNCHANGE = 25;
    public final double MAXPRESTIGECHANGE = 25;
    public final double MAXSECURITYCHANGE = 25;

    private double food;
    private double sleep;
    private double hygiene;
    private double fun;
    private double prestige;
    private double security;
    private double health;
    public Needs(double food, double sleep, double hygiene, double fun, double prestige, double security, double health) {
        this.food = food;
        this.fun = fun;
        this.hygiene = hygiene;
        this.prestige = prestige;
        this.security = security;
        this.sleep = sleep;
        this.health = health;
    }
    //Selfmade functions
    public void update(Personality personality){
        food -= 100 + MAXFOODCHANGE*(personality.getHungriness()/100);
        sleep -= 100 + MAXSLEEPINESSCHANGE * (personality.getSleepiness()/100);
        hygiene -= 100 + MAXHYGINECHANGE * (personality.getImportanceOfHygiene()/100);
        fun -= 100 + MAXFUNCHANGE *(personality.getBoredomTolerance()/100);
        prestige -= 100 + MAXPRESTIGECHANGE * (personality.getImportanceOfPrestige()/100);
        security -= 100 + MAXSECURITYCHANGE * (personality.getImportanceOfSecurity()/100);
    }
    public boolean isAlive(){
        return health > 0;
    }
    //Getter and Setter
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getSleep() {
        return sleep;
    }

    public void setSleep(double sleep) {
        this.sleep = sleep;
    }

    public double getHygiene() {
        return hygiene;
    }

    public void setHygiene(double hygiene) {
        this.hygiene = hygiene;
    }

    public double getFun() {
        return fun;
    }

    public void setFun(double fun) {
        this.fun = fun;
    }

    public double getPrestige() {
        return prestige;
    }

    public void setPrestige(double prestige) {
        this.prestige = prestige;
    }

    public double getSecurity() {
        return security;
    }

    public void setSecurity(double security) {
        this.security = security;
    }
}
