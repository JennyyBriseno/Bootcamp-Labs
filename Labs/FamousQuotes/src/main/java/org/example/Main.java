package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] quotes = new String[11];
        quotes[0] = "The only way to do great work is to love what you do.";
        quotes[1] = "In the end, it's not the years in your life that count. It's the life in your years.";
        quotes[2] = "The greatest glory in living lies not in never falling, but in rising every time we fall.";
        quotes[3] = "The only limit to our realization of tomorrow will be our doubts of today.";
        quotes[4] = "The only thing necessary for the triumph of evil is for good men to do nothing.";
        quotes[5] = "Life is what happens when you're busy making other plans.";
        quotes[6] = "It does not matter how slowly you go as long as you do not stop.";
        quotes[7] = "In three words I can sum up everything I've learned about life: it goes on.";
        quotes[9] = "Believe you can and you're halfway there.";
        quotes[10] = "The only thing we have to fear is fear itself";

        String loop = "";
        do{
            try {
                System.out.print("Choose a number between 1-10: ");
                int number = Integer.parseInt(scanner.nextLine());

                System.out.println(quotes[number]);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("That number is out of range. Try again.");
            } catch (InputMismatchException ex) {
                System.out.println("Please type in a number. ");
            }catch (NumberFormatException ex){
                System.out.println("Please put in a number. ");
            }
            System.out.println("Would you like to choose another number? ");
            loop = scanner.nextLine();
        }
            while(loop.equalsIgnoreCase("yes"));
        }
    }

