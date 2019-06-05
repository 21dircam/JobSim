package org.pltw.examples.simjob;

public class Promotion {

    private int promotion;
    private String objectId;

    public Promotion(){

    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }
    public void mulitplyPromotion(int mulitply) {
        this.promotion = promotion * mulitply;
    }

    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }



}
