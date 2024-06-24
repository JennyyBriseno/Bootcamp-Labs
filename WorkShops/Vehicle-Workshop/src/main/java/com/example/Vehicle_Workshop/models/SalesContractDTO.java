package com.example.Vehicle_Workshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesContractDTO {
    private String contractDate;
    private String customerName;
    private String customerEmail;
    private int vehicleVin;
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;
}
