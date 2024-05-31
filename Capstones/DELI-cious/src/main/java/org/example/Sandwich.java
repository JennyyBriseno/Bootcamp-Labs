package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements ForSale{
    private Toppings toppings;
    private SandwichSize sandwichSize;
    private boolean toastedOption;
    private int meatCounter;
    private int cheeseCounter;
    private String bread;

    public List<String> meats = new ArrayList<>();
    public List<String> cheese = new ArrayList<>();
    public List<String> regularToppings = new ArrayList<>();

    public Sandwich(String bread, SandwichSize sandwichSize, boolean toastedOption) {
        this.bread = bread;
        this.sandwichSize = sandwichSize;
        this.toastedOption = toastedOption;
    }

    public Toppings getToppings() {
        return toppings;
    }

    public void setToppings(Toppings toppings) {
        this.toppings = toppings;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public boolean isToastedOption() {
        return toastedOption;
    }

    public void setToastedOption(boolean toastedOption) {
        this.toastedOption = toastedOption;
    }

    public int getMeatCounter() {
        return meatCounter;
    }

    public int getCheeseCounter() {
        return cheeseCounter;
    }

    public String getBread() {
        return bread;
    }

    public List<String> getMeats() {
        return meats;
    }

    public List<String> getCheese() {
        return cheese;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    @Override
    public double getPrice(){
        //make sure to increment counter in UI
        double sum = sandwichSize.basePrice;
        if(meats.size() >= 1){
            sum += sandwichSize.meat + (sandwichSize.extraMeat * (meats.size() - 1));
        }
        if(cheese.size() >= 1){
            sum += sandwichSize.cheese + (sandwichSize.extraCheese * (cheese.size() - 1));
        }
        return sum;
    }
}
