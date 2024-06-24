package com.example.Vehicle_Workshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseContractDTO {
    private String contractDate;
    private String customerName;
    private String customerEmail;
    private int vehicleVin;
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;
}
