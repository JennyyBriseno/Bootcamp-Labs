package org.example;

public interface ForSale {
    public default double getPrice(){
        return 0;
    }
}
