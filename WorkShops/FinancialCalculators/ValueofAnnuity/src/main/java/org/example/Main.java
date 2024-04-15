package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //INTRODUCTION
        System.out.print("What is your name? ");
        String name = scanner.nextLine();

        System.out.printf("Hello %s, Welcome to Jenny's Present Value of Annuity Calculator!\n", name);
        System.out.println("""
                We will need the following information...
                Payment Amount(Monthly):
                Annual interest rate:
                Number of years:
                """);
        System.out.println("Please make sure to fill out all information accordingly...");
        System.out.print("What is your monthly payment amount?: $");
        double monthlyPayment = scanner.nextDouble();
        System.out.println("Great!\n");
        System.out.print("Now, What is your annual interest rate?: %");
        double interestRate = scanner.nextDouble();
        System.out.println("Awesome! Next question!\n");
        System.out.print("How many years to pay out?: ");
        double years = scanner.nextDouble();

        //CALLING THE FUNCTIONS
        double newInterest = newInterest(interestRate);
        double months = months(years);
        double presentValue = presentValue(monthlyPayment, newInterest, months);

        System.out.printf("""
                Based on the information you provided us...
                Monthly payment: $%.2f
                Interest Rate: %.3f 
                Number of years: %.0f years
                """, monthlyPayment, interestRate, years);
        System.out.printf("To fund this annuity, you would need to invest: $%.2f ", presentValue);
    }

    //CREATING FUNCTIONS
    //NEW INTEREST
    public static double newInterest(double interestRate) {
        double newInterest = (interestRate / 12) / 100;
        return newInterest;
    }

    //YEARS TO MONTHS
    public static double months(double years) {
        double months = years * 12;
        return months;
    }

    //Calculating present value
    public static double presentValue(double monthlyPayment, double newInterest, double months) {
        double presentValue = monthlyPayment * (1 - Math.pow((1 + newInterest), (-months))) / newInterest;
        return presentValue;
    }

}
//PSUEDO CODE
//Steps:
//
//Introdoction:
//Perform a welcoming
//List out the information needed{
//    monthly payment
//    annual interest rate
//    number of years
//}
//Ask the customer for each one:
//monthly payment
//      collect their input
//annual interest rate
//      collect their input
//      perform a function that divides interest rate by 12 and then dividing it by 100
//number of years
//      collect their input
//      perform a function that multiplies the years by 12(months) in order to get number of monthly payments
//Perform a function that calculates the present value of the annuity
//Formula: PV = PMT * [(1 - (1 + r)^(n))/r]
//PV:Present Value
//PMT: Monthly payment
//r: monthly interest rate (multiply annual interest rate by 12 then by 100)
//n: Number of monthly payments  (multiply years by 12)
//
//Display calculation for PV and information gathered
