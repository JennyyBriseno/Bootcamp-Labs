package org.example;

import java.util.Scanner;

import static org.example.Library.bookList;


public class Screens {
//Displays initial options
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        //ask about recursion
        while (true) {
            System.out.println("Hello and Welcome to Jenny's Library!\nPlease select an option: ");
            System.out.println("""
                    1) I would like to see the available books.
                    2) I would like to see the checked out books.
                    3) I would like to exit.
                    """);
            String selection = scanner.nextLine();
            switch (selection.toLowerCase()) {
                case ("1"):
                    Screens.availableBooks();
                    break;
                case ("2"):
                    Screens.checkedOutBooks();
                    break;
                case ("3"):
                    System.out.println("You chose to exit. ");
                    System.exit(0);
                default:
                    System.out.println("Sorry that is not an option :( ");
                    homeScreen();
                    break;
            }
            return;
        }
    }

    //Displays all available books
    public static void availableBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here is a list of available books to check out! ");
        Library.checkedInBooks(false);
        while(true) {
            System.out.println("""
                    Choose an option:
                    1) Checkout a book
                    2) Return to home screen
                    """);
            String selection2 = scanner.nextLine();
            switch (selection2.toLowerCase()) {
                case ("1"):
                    Screens.checkOutBook();
                    break;
                case ("2"):
                    Screens.homeScreen();
                    break;
                default:
                    System.out.println("Sorry that is not an option. :( ");
                    availableBooks();
                    break;
            }
            return;
        }
    }

//Method to check out the books
    public static void checkOutBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What book would you like to check out? Please select an ID: ");
        int idChosen = scanner.nextInt();
        int counter = 0;
        scanner.nextLine();
        System.out.println("What is your name? ");
        String nameOfPerson = scanner.nextLine();
        for (Books books : bookList) {
            if (books.getId() == idChosen) {
                books.checkOut(nameOfPerson);
                System.out.println(nameOfPerson + " : " + books.getTitle());
                Screens.homeScreen();
            }
            counter++;
        }
        if (counter == 0) {
            System.out.println("The ID is invalid, please try again! ");
            checkOutBook();
        }
    }

    //Method that displays checked out books
    public static void checkedOutBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here is a list of checked out books: ");
        Library.checkedOutBooks(true);
        System.out.println("""
                    Choose an option:
                    1) Check in a book
                    2) Return to home screen
                    """);
        String selection2 = scanner.nextLine();
        switch (selection2.toLowerCase()) {
            case ("1"):
                Screens.checkInBook();
                break;
            case ("2"):
                Screens.homeScreen();
                break;
            default:
                System.out.println("Sorry that is not an option. :( ");
                availableBooks();
                break;
        }

    }

    //Method that checks in book
    public static void checkInBook() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        System.out.println("What book would you like to check in? Please select an ID: ");
        int idChosen = scanner.nextInt();
        scanner.nextLine();
        for (Books books : bookList) {
            if (idChosen == books.getId()) {
                System.out.println(books.getCheckedOutTo() + " : " + books.getTitle());
                books.checkIn();
                homeScreen();
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("The ID is invalid, please try again! ");
            checkInBook();
        }
    }
}
