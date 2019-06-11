package org.pltw.examples.simjob;

public class Promotion {

    private int multiplier;
    private String objectId;

    public Promotion(){

    }
    public Promotion(int multiplier){
        this.multiplier = multiplier;
    }

    public int getPromotion() {
        return multiplier;
    }

    public void setPromotion(int promotion) {
        this.multiplier = promotion;
    }
    public void mulitplyPromotion(int mulitply) {
        this.multiplier = multiplier * mulitply;
    }

    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }



}
