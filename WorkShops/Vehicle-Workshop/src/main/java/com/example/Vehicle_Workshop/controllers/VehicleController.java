package com.example.Vehicle_Workshop.controllers;

import com.example.Vehicle_Workshop.models.Vehicle;
import com.example.Vehicle_Workshop.models.params.VehicleSearchParams;
import com.example.Vehicle_Workshop.repositories.VehicleRepository;
import com.example.Vehicle_Workshop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/Vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        var vehicles = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @DeleteMapping("/{vin}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable int vin){
        vehicleService.deleteVehicle(vin);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle){
        vehicleService.createVehicle(vehicle);

        return new ResponseEntity<>(vehicle,HttpStatus.OK);
    }

    @PutMapping("/{vin}")
    public ResponseEntity<Vehicle> updateVehicle(@Valid @RequestBody Vehicle vehicle, @PathVariable int vin){
        vehicleService.updateVehicle(vehicle,vin);

        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Vehicle>> searchVehicles(@ModelAttribute VehicleSearchParams searchParams){
        var vehicles = vehicleService.searchVehicles(searchParams);

        return new ResponseEntity<>(vehicles,HttpStatus.OK);
    }
}
