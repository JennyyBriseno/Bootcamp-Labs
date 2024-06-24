package com.example.Vehicle_Workshop.services;

import com.example.Vehicle_Workshop.models.LeaseContractDTO;
import com.example.Vehicle_Workshop.models.SalesContractDTO;
import com.example.Vehicle_Workshop.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.dgc.Lease;

@Service
public class ContractService {
    @Autowired
    ContractRepository contractRepository;

    public SalesContractDTO getSalesContractById(Long id){
        var salesContract = contractRepository.displaySalesContractById(id);

        return salesContract;
    }

    public LeaseContractDTO getLeaseContractById(Long id){
        var leaseContract = contractRepository.displayLeaseContractById(id);

        return leaseContract;
    }

    public SalesContractDTO createSalesContract(SalesContractDTO dto){
        SalesContractDTO salesContractDTO = new SalesContractDTO();
        salesContractDTO.setContractDate(dto.getContractDate());
        salesContractDTO.setCustomerName(dto.getCustomerName());
        salesContractDTO.setCustomerEmail(dto.getCustomerEmail());
        salesContractDTO.setVehicleVin(dto.getVehicleVin());
        salesContractDTO.setSalesTaxAmount(dto.getSalesTaxAmount());
        salesContractDTO.setRecordingFee(dto.getRecordingFee());
        salesContractDTO.setProcessingFee(dto.getProcessingFee());
        salesContractDTO.setFinanceOption(dto.isFinanceOption());
        contractRepository.addSalesContract(salesContractDTO);

        return salesContractDTO;
    }

    public LeaseContractDTO createLeaseContract(LeaseContractDTO dto){
        LeaseContractDTO leaseContractDTO = new LeaseContractDTO();
        leaseContractDTO.setContractDate(dto.getContractDate());
        leaseContractDTO.setCustomerName(dto.getCustomerName());
        leaseContractDTO.setCustomerEmail(dto.getCustomerEmail());
        leaseContractDTO.setVehicleVin(dto.getVehicleVin());
        leaseContractDTO.setExpectedEndingValue(dto.getExpectedEndingValue());
        leaseContractDTO.setLeaseFee(dto.getLeaseFee());
        leaseContractDTO.setMonthlyPayment(dto.getMonthlyPayment());
        contractRepository.addLeaseContract(leaseContractDTO);

        return leaseContractDTO;
    }
}
