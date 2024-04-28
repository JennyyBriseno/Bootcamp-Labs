package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testScores = {99, 88, 50, 60, 100, 99 , 80, 67, 77, 50};

        int sum = 0;
        for(int i = 0; i < testScores.length; i++) {
            sum += testScores[i];

//                  EASY WAY
//            System.out.println(testScores[0]);
//            System.out.println(testScores[9]);
//            System.out.println(average);
        }
        double average = sum / testScores.length;


        Arrays.sort(testScores);

        int highValue = 0;
        int lowValue = 101;

        for(int i = 0; i < testScores.length; i++){
            if(i < lowValue){
                lowValue = testScores[i];
            }
            if(i > highValue){
                highValue = testScores[i];
            }
        }
        System.out.printf("""
                          Average %.2f
                          High Score %d
                          Low Score %d
                          """,average, lowValue, highValue);
    }

}