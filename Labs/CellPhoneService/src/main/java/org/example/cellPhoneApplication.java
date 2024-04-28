package org.example;

import java.util.Scanner;

public class cellPhoneApplication {
    public static void main(String[] args) {
        cellPhone user1 = questions();
        cellPhone user2 = questions();
        cellPhone user3 = new cellPhone(9909090,"iphone8","t-mobile", "214-343-2342", "Jenny");

        user1.dial(user2.getOwner(),user1.getPhoneNumber());
        user2.dial(user1.getOwner(), user2.getPhoneNumber());

        display(user1);
        display(user2);
        display(user3);
    }

    public static cellPhone questions() {
        Scanner scanner = new Scanner(System.in);
        cellPhone phone = new cellPhone();
        System.out.print("What is your serial number? ");
        phone.setSerialNumber(scanner.nextInt());

        scanner.nextLine();

        System.out.print("What is the model? ");
        phone.setModel(scanner.nextLine());

        System.out.print("Who is your carrier? ");
        phone.setCarrier(scanner.nextLine());

        System.out.print("What is your phone number? ");
        phone.setPhoneNumber(scanner.nextLine());

        System.out.print("What is the name of the owner? ");
        phone.setOwner(scanner.nextLine());

        return phone;
    }
    public static void display(cellPhone user1) {
        System.out.println(user1.getSerialNumber()+ "\n " + user1.getModel() + "\n" + user1.getCarrier() + "\n " + user1.getPhoneNumber() + "\n " + user1.getOwner());
    }
}





