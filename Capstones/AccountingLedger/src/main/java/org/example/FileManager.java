package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileManager {
    private static final String filepath = "src/main/resources/transactions.csv";
    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filepath)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String date = data[0];
                String time = data[1];
                String description = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("Sorry, file not found! ");
        }
        return transactions;
    }

    public static void writeTransactionToFile(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
            writer.newLine();

            writer.write(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" +
                    transaction.getVendor() + "|" + transaction.getAmount());
        } catch (IOException e) {
            System.out.println("File could not be written to :( ");
        }
    }

    public static void addDeposit() {
        try {
            Transaction deposit = new Transaction();
            System.out.println("Please enter a short description of the deposit: ");
            String description = scanner.nextLine();
            deposit.setDescription(description);

            System.out.println("Please enter name of vendor: ");
            String vendor = scanner.nextLine();
            deposit.setVendor(vendor);

            System.out.println("Please enter the amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            deposit.setAmount(amount);

            FileManager.writeTransactionToFile(deposit);
        } catch (Exception e) {
            System.out.println("⚠ ERROR! THAT IS NOT AN OPTION, PLEASE TRY AGAIN! ⚠\n");
        }
        Screens.moreOptions();
    }

    public static void makePayment() {
        try {
            Transaction payment = new Transaction();
            System.out.println("🌸Please enter a short description of the payment🌸 ");
            String paymentDescription = scanner.nextLine();
            payment.setDescription(paymentDescription);

            System.out.println("🌸Please enter the name of vendor🌸");
            String paymentVendor = scanner.nextLine();
            payment.setVendor(paymentVendor);

            System.out.println("🌸Please enter the amount🌸 ");
            double paymentAmount = Double.parseDouble(scanner.nextLine());
            double amount = paymentAmount * (-1);
            payment.setAmount(amount);

            FileManager.writeTransactionToFile(payment);
        } catch (Exception e) {
            System.out.println("⚠ ERROR! THAT IS NOT AN OPTION, PLEASE TRY AGAIN! ⚠\n");
        }
        Screens.moreOptions2();
    }
    public static void displayAllEntries() {
        ArrayList<Transaction> transactions = FileManager.getTransactions();
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            System.out.println(transaction);
        }
    }
    public static void displayAllDeposits() {
        ArrayList<Transaction> transactions1 = FileManager.getTransactions();
        for (int i = transactions1.size() - 1; i >= 0; i--) {
            if ((transactions1.get(i).getAmount() > 0)) {
                System.out.println(transactions1.get(i));
            }
        }
    }
    public static void displayAllPayments() {
        ArrayList<Transaction> transactions2 = FileManager.getTransactions();
        for (int i = transactions2.size() - 1; i >= 0; i--) {
            if ((transactions2.get(i).getAmount() < 0)) {
                System.out.println(transactions2.get(i));
            }
        }
    }


}
