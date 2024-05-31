package org.example;

public enum SandwichSize {
    FOURINCH(5.5,1, .50, .75,.30),
    EIGHTINCH(7.0, 2.0, 1.0, 1.5, .60),
    TWELVEINCH(8.5,3.0,1.5, 2.25, .90),
    ;

    double basePrice;
    double meat;
    double extraMeat;
    double cheese;
    double extraCheese;

    SandwichSize(double basePrice, double premiumPrice, double extraMeatPrice, double cheese, double extraCheese) {
        this.basePrice = basePrice;
        this.meat = premiumPrice;
        this.extraMeat = extraMeatPrice;
        this.cheese = cheese;
        this.extraCheese = extraCheese;
    }

    public double getExtraCheese() {
        return extraCheese;
    }

    public double getCheese() {
        return cheese;
    }

    public double getExtraMeat() {
        return extraMeat;
    }

    public double getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
