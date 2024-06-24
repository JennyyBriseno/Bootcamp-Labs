package com.example.Vehicle_Workshop.repositories;

import com.example.Vehicle_Workshop.models.Vehicle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class VehicleRepository {
    @Autowired
    private DataSource basicDataSource;

    public List<Vehicle> getAllVehicles() {
        String query = "{CALL GetAlLVehicles}";

        List<Vehicle> allVehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                allVehicles.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allVehicles;
    }

    public List<Vehicle> getVehicleByPriceRange(double minPrice, double maxPrice) {
        String query = "{CALL GetVehiclesByPriceRange(?,?)}";

        List<Vehicle> vehiclesByPrice = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setDouble(1, minPrice);
            cs.setDouble(2, maxPrice);
            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByPrice.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehiclesByPrice;
    }

    public List<Vehicle> getVehicleByMakeAndModel(String make, String model) {
        String query = "{CALL GetVehiclesByMakeAndModel(?,?)}";

        List<Vehicle> vehiclesByMakeAndModel = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, make);
            cs.setString(2, model);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByMakeAndModel.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehiclesByMakeAndModel;
    }

    public List<Vehicle> getVehicleByMake(String make) {
        String query = "{CALL GetVehiclesByMake(?)}";

        List<Vehicle> vehiclesByMake = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, make);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByMake.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehiclesByMake;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        String query = "{CALL GetVehiclesByMileage(?,?)}";

        List<Vehicle> vehiclesByMileage = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, min);
            cs.setInt(2, max);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByMileage.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehiclesByMileage;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        String query = "{CALL GetVehiclesByYearRange(?,?)}";

        List<Vehicle> vehiclesByYear = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, min);
            cs.setInt(2, max);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByYear.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehiclesByYear;
    }

    public List<Vehicle> getVehiclesByColor(String colorChosen) {
        String query = "{CALL GetVehiclesByColor(?)}";

        List<Vehicle> vehiclesByColor = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, colorChosen);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByColor.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehiclesByColor;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        String query = "{CALL GetVehiclesByType(?)}";

        List<Vehicle> vehiclesByType = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, type);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByType.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehiclesByType;
    }

    public void removeVehicle(int vin) {
        String query = "{CALL RemoveVehicle(?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, vin);

            cs.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void addVehicles(Vehicle vehicle) {
        String query = "{CALL AddVehicle(?,?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, vehicle.getVin());
            cs.setInt(2, vehicle.getYear());
            cs.setString(3, vehicle.getVehicleMake());
            cs.setString(4, vehicle.getVehicleModel());
            cs.setString(5, vehicle.getVehicleType());
            cs.setString(6, vehicle.getColor());
            cs.setInt(7, vehicle.getOdometer());
            cs.setDouble(8, vehicle.getPrice());

            cs.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Vehicle findVehicle(int vin) {
        String query = "{CALL FindByVin(?)}";

        Vehicle vehicle = new Vehicle();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, vin);
            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");
                vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return vehicle;
    }

    public void updateVehicle(Vehicle vehicle) {
        String query = "{CALL updateVehicle(?,?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, vehicle.getVin());
            cs.setInt(2, vehicle.getYear());
            cs.setString(3, vehicle.getVehicleMake());
            cs.setString(4, vehicle.getVehicleModel());
            cs.setString(5, vehicle.getVehicleType());
            cs.setString(6, vehicle.getColor());
            cs.setInt(7, vehicle.getOdometer());
            cs.setDouble(8, vehicle.getPrice());

            cs.executeQuery();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
