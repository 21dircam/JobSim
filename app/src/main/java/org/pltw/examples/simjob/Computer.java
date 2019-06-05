package org.pltw.examples.simjob;

public class Computer {
    private int computer;
    private String objectId;

    public Computer(){

    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        this.computer = computer;
    }
    public void mulitplyComputer(int mulitply) {
        this.computer = computer * mulitply;
    }
    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
