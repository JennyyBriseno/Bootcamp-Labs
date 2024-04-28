package org.example;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //Format 1
        LocalDateTime todayDate = LocalDateTime.now();
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");;
        System.out.println(todayDate.format(formatter));

        //Format 2
        DateTimeFormatter formatter4;
        formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(todayDate.format(formatter4));


        //Format3
        DateTimeFormatter formatter2;
        formatter2 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(todayDate.format(formatter2));


        //Format 4
        DateTimeFormatter formatter3;
        formatter3 = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy, HH:mm");
        System.out.println(todayDate.format(formatter3));

//        //Format 5
//        DateTimeFormatter formatter4;
//        LocalDateTime todayDate4 = LocalDateTime.now();
//        formatter4 = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
//        System.out.println( "on " + todayDate4.format(formatter4));
    }
}