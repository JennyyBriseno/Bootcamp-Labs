package com.example.Vehicle_Workshop.services;

import com.example.Vehicle_Workshop.models.Vehicle;
import com.example.Vehicle_Workshop.models.params.VehicleSearchParams;
import com.example.Vehicle_Workshop.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(){
        List<Vehicle> allVehicles = vehicleRepository.getAllVehicles();

        return allVehicles;
    }

    public void deleteVehicle(int vin){
        vehicleRepository.removeVehicle(vin);
    }

    public Vehicle createVehicle(Vehicle vehicle){
        vehicleRepository.addVehicles(vehicle);
        return vehicle;
    }

    public void updateVehicle(Vehicle vehicle,int vin){
        Vehicle updateVehicle = vehicleRepository.findVehicle(vin);
        updateVehicle.setVehicleMake(vehicle.getVehicleMake());
        updateVehicle.setVehicleModel(vehicle.getVehicleModel());
        updateVehicle.setVehicleType(vehicle.getVehicleType());
        updateVehicle.setPrice(vehicle.getPrice());
        updateVehicle.setColor(vehicle.getColor());
        updateVehicle.setOdometer(vehicle.getOdometer());
        updateVehicle.setYear(vehicle.getYear());
        vehicleRepository.updateVehicle(updateVehicle);
    }

    public List<Vehicle> searchVehicles(VehicleSearchParams searchParams){
        List<Vehicle> vehicles = new ArrayList<>();
        if(searchParams.getMake() == null && searchParams.getModel() == null && searchParams.getType() == null
                && searchParams.getColor() == null && searchParams.getMinMiles() == null && searchParams.getMaxMiles() == null
            && searchParams.getMinPrice() == null && searchParams.getMaxPrice() == null && searchParams.getMinYear() == null
            && searchParams.getMaxYear() == null){
            vehicles = vehicleRepository.getAllVehicles();
        }
        else if(searchParams.getMake() != null && searchParams.getModel() != null) {
            vehicles = vehicleRepository.getVehicleByMakeAndModel(searchParams.getMake(), searchParams.getModel());
        }
        else if(searchParams.getType() != null){
            vehicles = vehicleRepository.getVehiclesByType(searchParams.getType());
        }
        else if(searchParams.getColor() != null){
            vehicles = vehicleRepository.getVehiclesByColor(searchParams.getColor());
        }
        else if(searchParams.getMinPrice() != null && searchParams.getMaxPrice() != null){
            vehicles = vehicleRepository.getVehicleByPriceRange(searchParams.getMinPrice(), searchParams.getMaxPrice());
        }
        else if(searchParams.getMinMiles() != null && searchParams.getMaxMiles() != null){
            vehicles = vehicleRepository.getVehicleByMileage(searchParams.getMinMiles(), searchParams.getMaxMiles());
        }
        else{
            vehicles = vehicleRepository.getVehiclesByYear(searchParams.getMinYear(), searchParams.getMaxYear());
        }
        return vehicles;
    }
}
