package org.pltw.examples.simjob;

public class Suit {
    private int suit;
    private String objectId;

    public Suit(){

    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void mulitplySuit(int mulitply) {
        this.suit = suit * mulitply;
    }
    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
