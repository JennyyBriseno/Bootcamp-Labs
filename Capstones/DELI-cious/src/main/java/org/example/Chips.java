package org.example;


import java.util.Arrays;
import java.util.List;

public class Chips implements ForSale{
    public static final List<String> chipFlavor = Arrays.asList("Classic/Plain", "Lemon Lays", "Doritos Flamas", "Sour Cream and Onion", "Barbeque", "Honey Barbeque", "Munchies", "Hot Puffs", "Doritos Nacho Cheese","Doritos Dinamita", "Hot Fries");
    //Display chipFlavor in UI
    private String chipType;
    private static final double price = 1.5;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    @Override
    public double getPrice(){
        return price;
    }

}
