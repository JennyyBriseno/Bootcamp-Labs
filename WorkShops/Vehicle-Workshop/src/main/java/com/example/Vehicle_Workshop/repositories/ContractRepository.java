package com.example.Vehicle_Workshop.repositories;

import com.example.Vehicle_Workshop.models.LeaseContractDTO;
import com.example.Vehicle_Workshop.models.SalesContractDTO;
import com.example.Vehicle_Workshop.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractRepository {
    @Autowired
    private DataSource basicDataSource;

    public void addSalesContract(SalesContractDTO salesContractdto) {
        String query = "{CALL SalesContract(?,?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, salesContractdto.getContractDate());
            cs.setBoolean(2, salesContractdto.isFinanceOption());
            cs.setDouble(3, salesContractdto.getSalesTaxAmount());
            cs.setDouble(4, salesContractdto.getRecordingFee());
            cs.setDouble(5, salesContractdto.getProcessingFee());
            cs.setString(6, salesContractdto.getCustomerName());
            cs.setString(7, salesContractdto.getCustomerEmail());
            cs.setInt(8, salesContractdto.getVehicleVin());

            cs.executeQuery();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void addLeaseContract(LeaseContractDTO leaseContractdto) {
        String query = "{CALL LeaseContract(?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, leaseContractdto.getContractDate());
            cs.setString(2, leaseContractdto.getCustomerName());
            cs.setString(3, leaseContractdto.getCustomerEmail());
            cs.setInt(4, leaseContractdto.getVehicleVin());
            cs.setDouble(5, leaseContractdto.getExpectedEndingValue());
            cs.setDouble(6, leaseContractdto.getLeaseFee());
            cs.setDouble(7, leaseContractdto.getMonthlyPayment());

            cs.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Vehicle> isVehicleAvailable(int vin) {
        String query = "{CALL GetVehicleByAvail(?)}";

        List<Vehicle> isVehicleAvailable = new ArrayList<>();

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

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                isVehicleAvailable.add(vehicle);
            }
        } catch (SQLException exception) {
        }
        return isVehicleAvailable;
    }

    public SalesContractDTO displaySalesContractById(Long id) {
        String query = "{CAll GetSalesContractById(?)}";

        SalesContractDTO salesContractdto = new SalesContractDTO();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setLong(1, id);
            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                String salesContractDate = resultSet.getString("SalesContractDate");
                double salesTaxAmount = resultSet.getDouble("SalesTaxAmount");
                int recordingFee = resultSet.getInt("RecordingFee");
                int processingFee = resultSet.getInt("ProcessingFee");
                String customerName = resultSet.getString("CustomerName");
                String customerEmail = resultSet.getString("CustomerEmail");
                int vehicleVin = resultSet.getInt("VehicleVin");
                boolean financeOption = resultSet.getBoolean("FinanceOption");
                salesContractdto = new SalesContractDTO(salesContractDate,customerName,customerEmail,vehicleVin, salesTaxAmount,recordingFee,processingFee,financeOption);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return salesContractdto;
    }

    public LeaseContractDTO displayLeaseContractById(Long id) {
        String query = "{CAll GetLeaseContractById(?)}";

        LeaseContractDTO leaseContractdto = new LeaseContractDTO();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setLong(1, id);
            ResultSet resultSet = cs.executeQuery();

            while(resultSet.next()){
                String leaseContractDate = resultSet.getString("LeaseContractDate");
                double expectingEndingValue = resultSet.getDouble("ExpectedEndingValue");
                double leaseFee = resultSet.getDouble("LeaseFee");
                String customerName = resultSet.getString("CustomerName");
                String customerEmail = resultSet.getString("CustomerEmail");
                int vehicleVin = resultSet.getInt("VehicleVin");
                double monthlyPayment = resultSet.getDouble("MonthlyPayment");
                leaseContractdto = new LeaseContractDTO(leaseContractDate,customerName, customerEmail, vehicleVin, expectingEndingValue, leaseFee, monthlyPayment);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return leaseContractdto;
    }
}
