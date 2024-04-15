package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //INTRODUCTION
        System.out.print("What is your name? ");
        String name = scanner.nextLine();

        System.out.printf("Hello %s, welcome to Jenny's Future CD Value Calculator!\n", name);
        System.out.println("""
                We will need the following information...
                Deposit
                Interest rate
                Number of years
                """);
        System.out.println("Please make sure to fill out all information accordingly...");
        System.out.print("What is your initial deposit? ");
        double initialDeposit = scanner.nextDouble();

        System.out.println("Great!\n");
        System.out.print("Now, what is the annual interest? ");
        double initialInterest = scanner.nextDouble();

        System.out.println("Awesome!\n");
        System.out.print("What is the number of years? ");
        double years = scanner.nextDouble();

        double n = 365;

        //CALLING THE FUNCTIONS
        double newInterest = newInterest(initialInterest);
        double futureValue = futureValue(initialDeposit, newInterest, years, n);
        double totalInterest = totalInterest(futureValue, initialDeposit);

        System.out.print("Here is your summary:\n");
        System.out.printf("""
                       Initial deposit: $%.2f
                       Initial interest: %.3f
                       Number of Years: %.0f years
                       Future Value: $%.2f
                       Total Interest Earned: $%.2f
                       """, initialDeposit, initialInterest, years, futureValue, totalInterest);
        System.out.println("Thank you for choosing Jenny's Future CD Calculator! Have a great day :) ");

    }
    //CREATING FUNCTIONS
        //New Interest
    public static double newInterest(double initialInterest){
       double newInterest = (initialInterest / 100) / 365;
        return newInterest;
    }
        //FutureValue
    public static double futureValue(double initialDeposit, double newInterest, double years, double n){
        double futureValue = initialDeposit * (Math.pow((1 + newInterest), (n * years)));
        return futureValue;
    }
        //TotalInterest
    public static double totalInterest(double futureValue, double initialDeposit){
        double totalInterest = (futureValue - initialDeposit);
        return totalInterest;
    }
}
//Pseudo Code(CD Calculator)
//purpose: To determine the future value of a CD
//
//Perform a welcoming :)
//list out the list of information that we will need {
//deposit
//interest rate
//number of years
// }
//Ask the customer for each one:
//
//-Deposit
//      collect their input
//-Interest rate
//      collect their input
//      perform a fuction(% to decimal and divide 365 to make the FV cleaner)
//-Number of years
//      collect their input
//
//Make the calculations for
//Future Value
//FV: P(1 + r/n)^(n*t)
//
//FV:Future Deposit
//P: initial deposit
//r: annual interest rate
//n: number of times interest is compounded every year(365)
//t: number of years
//
//Make the calculations for total interest
//Formula:
//
//TI: FV - P
//
//Display both calculations for user as well as the information gathered:)







