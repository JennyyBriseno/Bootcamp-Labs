package org.example;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to Jenny's Car Rental.");
        System.out.println("Please fill out the following questions in order to estimate the cost of your car rental! ");
        /*Variables used
        baseRental
        underAgeCharge
        daysNeeded
        tollTag
        gps
        roadsideService
        age
        options
        */
        //These variables need to be stated before any modification or else they aren't valid
        double baseRental = 29.99;
        double underAgeCharge = 0;
        System.out.print("What pickup date will work best for you? " + "Please write date as dd/mm/year: ");
        String pickupDate = scanner.nextLine();

        System.out.print("Great! \nNow, How many days will the rental be for? ");
        double daysNeeded = scanner.nextDouble();
        double total = baseRental * daysNeeded;

        scanner.nextLine();

        System.out.println("Awesome! \nNow, this is optional, but would you like an electronic toll tag for just $3.95/day? (Y/N)");
        String tollTag = scanner.nextLine();
        switch (tollTag.toUpperCase()) {
            case "Y":
                System.out.println("Your charge will now be added...");
                total = total + (3.95 * daysNeeded);
                break;
            case "N":
                System.out.println("okay! Next question! ");
                break;
            default:
                System.out.println("Error! Invalid input ;( ");
                return;
        }

        System.out.println("Would you like to include our GPS tracker for just $2.95/ day? (Y/N)");
        String gps = scanner.nextLine();
        switch (gps.toUpperCase()) {
            case "Y":
                System.out.println("Your charge will now be added...");
                total = total + (2.95 * daysNeeded);
                break;
            case "N":
                System.out.println("No worries! Next Question! ");
                break;
            default:
                System.out.println("Error ! Invalid input ;( ");
                return;
        }

        System.out.println("Would you like to include our roadside service charge for just $3.95/day? (Y/N)");
        String roadsideService = scanner.nextLine();
        switch (roadsideService.toUpperCase()) {
            case "Y":
                System.out.println("Great!, we will add that charge for you! ");
                total = total + (3.95 * daysNeeded);
                break;
            case "N":
                System.out.println("No worries! Last question:  ");
                break;
            default:
                System.out.println("Error! Invalid input ;( " );
                return;
        }

        System.out.println("What is your current age? ");
        int age = scanner.nextInt();
        if (age < 25) {
            System.out.println("A surcharge of 30% will now be added to your total...\nHere is your receipt: ");
            underAgeCharge = ((baseRental * daysNeeded) * .30);
            total = total + underAgeCharge;
        }
        else {
            System.out.println("Thank you! \nHere is your receipt: ");
        }

        double options = total - (baseRental * daysNeeded) - underAgeCharge;
        System.out.printf("BaseRental: $%.2f\nOptions: $%.2f\nUnderage driver surcharge: $%.2f\n------------------\nTotal: $%.2f\n", (baseRental * daysNeeded), options, underAgeCharge, total);

        System.out.println("Thank you for choosing Jenny's Car Rental! Have a great day! ;) ");
    }
}
/*
MY PSEUDO CODE
SETUP FOR CAR CALCULATOR SETUP!!!
Ask the person for these things:
-preferred pick-up date(as a String)
    collect their input
-how many days they will like for the rental
    collect their input
-If they want an electronic toll tag at $3.95/day (yes/no)
    collect their input
    calculate total
-If they want roadside assistance at $2.95/day (yes/no)
    collect their input
    calculate total
-If they want a gps for $3.95/day
    collect their input
    calculate total
-What their current age is
    collect their input
    add a charge of 30% if they are under 25 years
    -calculate based on their input
-display and calculate the basic car rental price plus the total of what they choose and total price overall
*/
