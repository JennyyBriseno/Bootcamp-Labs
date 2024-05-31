package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileManager {
    public static void writeToFile(String receipts){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String time = LocalDateTime.now().format(formatter);
        String filePath = "src/main/" + time + ".txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(Screens.receiptGenerator());
        }
        catch (IOException exception){
            System.out.println("File could not be written to....:( ");
        }
    }
    //Writing to the file
    //Add a date and time
}
