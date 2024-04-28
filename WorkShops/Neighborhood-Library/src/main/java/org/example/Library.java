package org.example;

import java.util.Arrays;

public class Library {

    static Books[] bookList = {
            new Books(0, "978-1423113461", "The Lost Hero "),
            new Books(1, "978-0060935467", "To Kill a Mockingbird "),
            new Books(2, "978-0743273565", "The Great Gatsby "),
            new Books(3, "978-0590353427", "Harry Potter and the Sorcerer's Stone "),
            new Books(4, "978-0553418026", "The Martian "),
            new Books(5, "978-0316015844", "Twilight "),
            new Books(6, "978-0316024969", "New Moon "),
            new Books(7, "978-0553382569", "I, Robot "),
            new Books(8, "978-0618640157", "The Lord of the Rings "),
            new Books(9, "978-0735219106", "Where the Crawdads Sing "),
            new Books(10, "978-0441172719", "Dune "),
            new Books(11, "978-0765382030", "The Three-Body Problem "),
            new Books(12, "978-0747538493", "Harry Potter and the Chamber of Secrets "),
            new Books(13, "978-0747542155", "Harry Potter and the Prisoner of Azkaban "),
            new Books(14, "978-1501110368", "It Ends with Us "),
            new Books(15, "978-0140177398", "Of Mice and Men "),
            new Books(16, "978-0385737951", "The Maze Runner "),
            new Books(17, "978-0385738767", "The Scorch Trials "),
            new Books(18, "978-1451673319", "Fahrenheit 451 "),
            new Books(19, "978-0142407332", "The Outsiders")
    };

    public static void checkedInBooks(boolean checkOut) {
        int counter = 0;
        for (Books books : bookList) {
            if (books.isCheckedOut() == checkOut) {
                System.out.println("ID: " + books.getId() + " ISBN: " + books.getIsbn() + " Title: " + books.getTitle());
                counter++;
            }
            if (counter == 0) {
            }
        }
    }

    public static void checkedOutBooks(boolean checkOut) {
        for (Books books : bookList) {
            if (books.isCheckedOut() == checkOut) {
                System.out.println("ID: " + books.getId() + " ISBN: " + books.getIsbn() + " Title: " + books.getTitle() + " Checked out to: " + books.getCheckedOutTo());
            }
        }
    }
}
