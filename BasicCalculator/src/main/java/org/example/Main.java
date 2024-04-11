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

        //calling my math functions
         double sum = addition(number1, number2);
         double difference = subtraction(number1, number2);
         double product = multiplication(number1, number2);
         double quotient = division(number1, number2);

        //applying my math functions
        if(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("Add")){
            System.out.printf("This is your sum: %.2f ", sum);
        }
        else if(option.equalsIgnoreCase("S") || option.equalsIgnoreCase("Subtract")){
            System.out.printf("This is your difference: %.2f ", difference);
        }
        else if(option.equalsIgnoreCase("M") || option.equalsIgnoreCase("Multiply")){
            System.out.printf("This is your product: %.2f ", product)   ;
        }
        else if(option.equalsIgnoreCase("D") || option.equalsIgnoreCase("Divide")){
            System.out.printf("This is your quotient: %.2f ", quotient);
        }
        else{
            System.out.println("The input you chose is invalid, please try again! ");
        }

    }
    //my math functions :0
    public static double addition(double number1, double number2){
        double sum = number1 + number2;
        return sum;
    }
    public static double subtraction(double number1, double number2){
        double difference = number1 - number2;
        return difference;
    }
    public static double multiplication(double number1, double number2){
        double product = number1 * number2;
        return product;
    }
    public static double division(double number1, double number2){
        double quotient = number1 / number2;
        return quotient;
    }

}