package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private static final String filePath = "src/main/resources/products.csv";
    private static final Scanner scanner = new Scanner(System.in);


    public static void displayProducts() {
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Sorry, file not found");
        }
    }

    public static void searchByName() {
        System.out.println("Please type in the name for the item. ");
        String productChosen = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(productChosen)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Sorry file not found ");
        }
    }

    //SEARCH BY DEPARTMENT
    public static void searchByDepartment() {
        System.out.println("Please type in the name of department: ");
        String departmentChosen = scanner.nextLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                reader.readLine();
                String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.toLowerCase().contains(departmentChosen)) {
                            System.out.println(line);
                    }
                 }
            } catch (IOException e) {
                    System.out.println("Sorry file not found ");
        }
    }

    public static void searchByPrice1() {
        System.out.print("Please choose your max price: ");
        double max = scanner.nextDouble();
        System.out.print("Please choose your min price: ");
        double min = scanner.nextDouble();
        for (Product product : getProducts()) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                System.out.println("Sku: " + product.getSku() + " | ProductName: " + product.getProductName() + " | Price: " + product.getPrice());
            }
        }
    }

    //Array for products file
    public static ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String sku = data[0];
                String productName = data[1];
                double price = Double.parseDouble(data[2]);
                String department = data[3];

                Product product = new Product(sku, productName, price, department);
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("Sorry, file not found");
        }
        return products;
    }
}

