package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        //make a filepath
        String path = "src/main/resources/employees.csv";
        //reading the file bit by bit
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            reader.readLine();
            //read until no values left
            while ((line = reader.readLine()) != null) {
                //separating the data
                String[] data = line.split("\\|");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double hoursWorked = Double.parseDouble(data[2]);
                double payRate = Double.parseDouble(data[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employees.add(employee);
            }
        } catch (IOException ex) {
            System.out.println("sorry file not found ");
        }

    for(Employee employee : employees){
        System.out.printf("Id: %d | Name: %s | HoursWorked: %.2f | PayRate: %.2f | GrossPay: %.2f\n", employee.getEmployeeId(), employee.getName(),
                employee.getHoursWorked(), employee.getPayRate(),Employee.getGrossPay(employee.getHoursWorked(),employee.getPayRate()));
        }
    return employees;
    }
}

