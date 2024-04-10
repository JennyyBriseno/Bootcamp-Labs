package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        float number1 = scanner.nextFloat();
        System.out.print("Enter the second number: ");
        float number2 = scanner.nextFloat();

        scanner.nextLine();

        System.out.print("""
                        Possible calculations:
                            (A)dd
                            (S)ubtract
                            (M)ultiply
                            (D)ivide
                        Please select an option:""");
        String option = scanner.nextLine();

        if(option.equalsIgnoreCase("A")){
            System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
        }
        else if(option.equalsIgnoreCase("S")){
            System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
        }
        else if(option.equalsIgnoreCase("M")){
            System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
        }
        else if(option.equalsIgnoreCase("D")){
            System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
        }
        else{
            System.out.println("The input you chose is invalid, please try again! ");
        }

    }
}