package org.example;

import java.util.Arrays;
import java.util.List;

public class Drinks implements ForSale{
    public static final List<String> drinkFlavor = Arrays.asList("Dr.Pepper", "Coca-Cola", "Big Red", "Cherry Cola", "Sprite", "Mountain Dew", "Manzanita", "Pineapple Jarrito", "Peach Soda", "Cream Soda", "Strawberry Cola");
    private DrinkSize size;
    private String flavor;

    public Drinks(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }
}
