package com.example.Vehicle_Workshop.models.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSearchParams {
    private String make;
    private String model;
    private String type;
    private String color;
    private Double minPrice;
    private Double maxPrice;
    private Integer minMiles;
    private Integer maxMiles;
    private Integer minYear;
    private Integer maxYear;
}
