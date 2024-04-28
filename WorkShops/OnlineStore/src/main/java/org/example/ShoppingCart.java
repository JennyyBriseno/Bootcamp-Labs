package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Product> shoppingCart = new ArrayList<>();

    public static void addingItems() {
        System.out.print("Enter SKU of item you would like to add to cart: ");
        String customerProduct = scanner.nextLine();
        ArrayList<Product> products = FileManager.getProducts();
        for (Product product : products) {
            if (product.getSku().equalsIgnoreCase(customerProduct)) {
                shoppingCart.add(product);
                //display cart method
//                for (Product showCart : ShoppingCart.shoppingCart) {
//                    System.out.println(showCart.getSku() + " | " + showCart.getProductName() + " | " + showCart.getPrice());
//                }
            }
        }
        Screens.moreOptions();
    }

    public static void removingItems() {
        System.out.print("Enter SKU of item you would like to remove to cart: ");
        String customerProduct = scanner.nextLine();


        ArrayList<Product> products = FileManager.getProducts();
        for (Product product : products) {
            if (product.getSku().equalsIgnoreCase(customerProduct)) {
                shoppingCart.remove(product);
                //display cart method
//                for (Product showCart : ShoppingCart.shoppingCart) {
//                    System.out.println(showCart.getSku() + " | " + showCart.getProductName() + " | " + showCart.getPrice());
//                }
            }
        }
        Screens.moreOptions();
    }

    public static double calculateTotal() {
        double sum = 0;
        for (Product product : ShoppingCart.shoppingCart) {
            sum += product.getPrice();
        }
        System.out.printf("""
                ------TOTAL------
                $%.2f
                """, sum);
        System.out.println("""
                 I hope you have a nice day! 
                                    _()/^)
                (^\\()_               _)\\<
                 >/(_     _.-.-.       \\\\)_
                (/\\\\     (_\\_|_/_)      \\  `
                  /|    (__>(@)<__)     `
                  ``     (_/^|^\\_)
                           '-'-'#,  _/\\
                                `# / _/
                            |\\_ ,#|/_/
                            \\ \\|#'
                             `-#' /|
                            /\\_# | /_
                               \\_.|#,__/
                       """);
        return sum;
    }
}
