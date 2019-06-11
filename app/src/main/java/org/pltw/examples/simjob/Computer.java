package org.pltw.examples.simjob;

public class Computer {
    private int multiplier;
    private String objectId;

    public Computer(){

    }
    public Computer(int multiplier){
        this.multiplier = multiplier;
    }

    public int getComputer() {
        return multiplier;
    }

    public void setComputer(int multiplier) {
        this.multiplier = multiplier;
    }
    public void mulitplyComputer(int mulitply) {
        this.multiplier = multiplier * mulitply;
    }
    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
