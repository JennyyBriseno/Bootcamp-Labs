package org.example;


import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.Buffer;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import static org.example.ShoppingCart.shoppingCart;


public class Screens {
    private static final Scanner scanner = new Scanner(System.in);

    public static void HomePage() {
        System.out.println("Hello fellow customers...Welcome to Jenny's online store. Have fun shopping!!! ");
        try {
            System.out.println("""
                    Please choose an option:
                    1) Display Products:
                    2) Display your cart:
                    3) Exit:
                    """);
            int choice1 = scanner.nextInt();
            switch (choice1) {
                case (1):
                    System.out.println("-----Products in store-----");
                    FileManager.displayProducts();
                    Screens.displayingProducts();
                    break;
                case (2):
                    System.out.println("------Cart------");
                    Screens.displayCart();
                    break;
                case (3):
                    System.out.println("Exiting online store! I hope to see you back soon! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry that is not an option! Please try again :( ");
                    Screens.HomePage();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please type in a valid input! ;( ");
        }
    }

    public static void displayingProducts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    What would like to do?
                    1) Search or filter list of products
                    2) Add a product to your cart
                    3) Back to home page!
                    """);
            int choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    Screens.searchOption();
                    break;
                case 2:
                    ShoppingCart.addingItems();
                    moreOptions();
                    break;
                case 3:
                    System.out.println("Redirecting to home screen... ");
                    HomePage();
                    break;
            }
            return;
        }
    }

    //SORTING OPTIONS METHOD
    public static void searchOption() {
        while (true) {
            System.out.println("""
                    How would you like to search products?
                    1)Search by name
                    2)Search by department
                    3)Search by price
                    """);
            int choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    FileManager.searchByName();
                    afterOptionRoute();
                    break;
                case 2:
                    FileManager.searchByDepartment();
                    afterOptionRoute();
                    break;
                case 3:
                    FileManager.searchByPrice1();
                    afterOptionRoute();
                    break;
                default:
                    System.out.println("Please choose a valid option");
                    Screens.searchOption();
            }
            return;
        }
    }

    //ASKING USER IF THEY WANT TO ADD ITEM TO CART
    public static void afterOptionRoute() {
        try {
            System.out.println("""
                    Would you like to add an item to cart?
                    1)Yes!
                    2)Prompt back to searching products
                    3)More options...
                    """);
            int choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    ShoppingCart.addingItems();
                    moreOptions();
                    break;
                case 2:
                    System.out.println("Prompting back to searching products...");
                    searchOption();
                    break;
                case 3:
                    FileManager.getProducts();
                    displayingProducts();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Something went wrong, please try again");
        }
    }

    public static void moreOptions() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    What would like to do?
                    1) Add a product
                    2) Remove a product
                    3) Check Out
                    4) Home Screen!
                    """);
            int choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    ShoppingCart.addingItems();
                    break;
                case 2:
                    ShoppingCart.removingItems();
                    break;
                case 3:
                    checkOut();
                    break;
                case 4:
                    System.out.println("Redirecting to home screen... ");
                    HomePage();
                    break;
            }
        }

    public static void displayCart() {
        System.out.println("""
                1) I would like to check out!
                2) I would like to remove a product
                3) I would like to go back to home screen
                """);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                checkOut();
                break;
            case 2:
                for (Product showCart : ShoppingCart.shoppingCart) {
                    System.out.println(showCart.getSku() + " | " + showCart.getProductName() + " | " + showCart.getPrice());
                }
                ShoppingCart.removingItems();
                break;
            case 3:
                HomePage();
                break;
            default:
                System.out.println("Sorry, that is not an option!");
                break;
        }
    }

    public static void checkOut() {
        if (ShoppingCart.shoppingCart.size() == 0) {
            System.out.println("------Shopping cart is empty------");
            HomePage();
        }
        System.out.println("--------YOUR RECEIPT--------");
        for (Product showCart : ShoppingCart.shoppingCart) {
            System.out.println(showCart.getSku() + " | " + showCart.getProductName() + " | " + showCart.getPrice());
        }
        ShoppingCart.calculateTotal();
        System.exit(0);
    }
}