package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Introduction
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        System.out.printf("Hello %s, Welcome to Jenny's mortgage calculator!\nWhere we calculate your monthly payment and the total interest payed for your loan! ", name);
        System.out.println("\nTo calculate your monthly payment and your total interest payed, we will need some information.\nPlease be sure to fill out everything accordingly! ");
        System.out.print("What is your principle(your loan amount)?: ");
        double principle = scanner.nextDouble();
        System.out.print("Great!\nNow, what is your yearly interest rate? ");
        double yearlyInterest = scanner.nextDouble();
        System.out.print("Awesome!\nNow, what is your loan length(in years)? ");
        double loanLengthYears = scanner.nextDouble();

        //calling the functions
        double monthlyInterest = monthlyInterest(yearlyInterest);
        double loanLengthInMonths = loanLengthInMonths(loanLengthYears);
        double monthlyPay = monthlyPayment(monthlyInterest,loanLengthInMonths, principle);
        double totalInterest = totalInterest(monthlyPay, principle, loanLengthInMonths);
        System.out.println("This is your summary:\n");
        System.out.printf("""
                             Principle: $%.2f\n
                             Yearly interest: %.3f\n
                             Loan length: %.0f years\n
                             --------------------------
                             Total monthly payment: $%.2f\n
                             Total interest payed: $%.2f\n
                             """, principle, yearlyInterest, loanLengthYears, monthlyPay, totalInterest);
        System.out.println("Thank you for choosing Jenny's Mortgage Calculator! Have a great day! ");
    }
    //conversion function from yearly to monthly interest rate
    public static double monthlyInterest(double yearlyInterest){
        double monthlyInterest = (yearlyInterest / 12) /100;
        return monthlyInterest;
    }
    //conversion function from years to months for loan length
    public static double loanLengthInMonths(double loanLengthInYears){
        double loanLengthInMonths = loanLengthInYears * 12;
        return loanLengthInMonths;
    }
    //monthly payment math
    public static double monthlyPayment(double monthlyInterest, double loanLengthInMonths, double principle) {
        double monthlyPay = principle * (monthlyInterest * (Math.pow((1 + monthlyInterest),loanLengthInMonths) / (Math.pow(1 + monthlyInterest, loanLengthInMonths) - 1)));
        return monthlyPay;
    }
    //total interest math
    public static double totalInterest(double monthlyPay, double principle, double loanLengthInMonths) {
        double totalInterest = (monthlyPay * loanLengthInMonths) - principle;
        return totalInterest;
    }


//    Pseudo Code(Mortgage Calculator)
//        purpose:calculate monthly pay for loan(base NO INSURANCE OR TAXES)and calculate how much it would be
//        over the life of the loan.
//
//        steps:
//        Perform a welcoming :)
//        print the purpose of the calculator
//        list out the list of information that we will need {
//            loan amount
//            interest rate
//            and loan length
//        }
//        ask the customer for each one
//        loan amount
//        collect their input
//        interest rate(yearly)
//                collect their input
//        perform a function
//        make a conversion of yearly interest rate to monthly interest rate
//        loan length
//        collect their input
//        perform a function
//        convert years to month calculation
//
//        make the final calculations to display monthly payment and total interest rate
//        use formula for monthly payment
//        M=P i(1+i)^n/((1+i)^n)-1
//
//        M-Monthly payment
//        P-Principle(loan amount)
//        i-Monthly interest rate
//        n-length of loan(IN MONTH)
//
//        calculate the interest
//        formula (monthlyPayment * lengthInMonths) - principle
///
//        Display the final calculations
//        monthly payment
//        total interest payed
}