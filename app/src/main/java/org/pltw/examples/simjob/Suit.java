package org.pltw.examples.simjob;

public class Suit {
    private int multiplier;
    private String objectId;

    public Suit(){

    }
    public Suit(int multiplier){
        this.multiplier = multiplier;
    }

    public int getSuit() {
        return multiplier;
    }

    public void setSuit(int suit) {
        this.multiplier = suit;
    }

    public void mulitplySuit(int mulitply) {
        this.multiplier = multiplier * mulitply;
    }
    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
