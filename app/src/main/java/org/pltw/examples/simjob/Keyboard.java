package org.pltw.examples.simjob;

public class Keyboard {
    private int keyboard;
    private String objectId;

    public Keyboard(){

    }

    public int getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(int keyboard) {
        this.keyboard = keyboard;
    }
    public void mulitplyKeyboard(int mulitply){
        this.keyboard = keyboard * mulitply;
    }

    public String getObjectId() {
        return objectId;
    }



    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}