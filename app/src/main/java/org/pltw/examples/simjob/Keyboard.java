package org.pltw.examples.simjob;

public class Keyboard {
    private double multiplier;
    private String objectId;

    public Keyboard(){

    }

    public Keyboard(double multiplier){
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
    public void mulitplyKeyboard(double mulitply){
        this.multiplier = multiplier * mulitply;
    }

    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
