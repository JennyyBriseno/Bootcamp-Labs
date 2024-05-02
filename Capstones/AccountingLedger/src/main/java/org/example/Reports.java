package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class Reports {
   private static final Scanner scanner = new Scanner(System.in);

    public static void filterByMonthToDate() {
        ArrayList<Transaction> transactions = FileManager.getTransactions();
        LocalDate currentDate = LocalDate.now();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String[] filter = transactions.get(i).getDate().split("-");
            int year = Integer.parseInt(filter[0]);
            int month = Integer.parseInt(filter[1]);
            if (currentDate.getMonth().equals(Month.of(month)) && currentDate.getYear() == year) {
                System.out.println(transactions.get(i));
            }
        }
    }

    public static void filterByPreviousMonth() {
        ArrayList<Transaction> transactions = FileManager.getTransactions();
        LocalDate currentDate = LocalDate.now();
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String[] filter = transactions.get(i).getDate().split("-");
            int year = Integer.parseInt(filter[0]);
            int month = Integer.parseInt(filter[1]);
            if (lastMonth.getMonth().equals(Month.of(month)) && currentDate.getYear() == year) {
                System.out.println(transactions.get(i));
            }
        }
    }

    public static void filterByYearToDate() {
        ArrayList<Transaction> transactions = FileManager.getTransactions();
        LocalDate currentDate = LocalDate.now();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String[] filter = transactions.get(i).getDate().split("-");
            int year = Integer.parseInt(filter[0]);
            if (currentDate.getYear() == (year)) {
                System.out.println(transactions.get(i));
            }
        }
    }
    public static void filterByPreviousYear() {
        ArrayList<Transaction> transactions = FileManager.getTransactions();
        LocalDate lastYear = LocalDate.now().minusYears(1);

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String[] filter = transactions.get(i).getDate().split("-");
            int year = Integer.parseInt(filter[0]);
            if (lastYear.getYear() == year) {
                System.out.println(transactions.get(i));
            }
        }
    }

    public static void searchByVendor() {
        System.out.println("Please type in a vendor name: ");
        String vendorName = scanner.nextLine();
        ArrayList<Transaction> transactions = FileManager.getTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            if (transactions.get(i).getVendor().toLowerCase().equals(vendorName)) {
                System.out.println(transactions.get(i));
            }
        }
    }
}