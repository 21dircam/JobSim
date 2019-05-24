package org.pltw.examples.simjob;

public class Money {
    private double money;

    public Money(){

    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double money) {
        this.money += money;
    }
}
