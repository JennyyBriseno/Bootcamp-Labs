package org.example;

public enum DrinkSize {
    SMALL(2.0),
    MEDIUM(2.5),
    LARGE(3.0),
    ;

    private final double price;
    DrinkSize(double price){
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
