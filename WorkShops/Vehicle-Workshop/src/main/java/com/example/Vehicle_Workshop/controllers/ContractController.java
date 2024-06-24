package com.example.Vehicle_Workshop.controllers;

import com.example.Vehicle_Workshop.models.LeaseContractDTO;
import com.example.Vehicle_Workshop.models.LeaseContracts;
import com.example.Vehicle_Workshop.models.SalesContractDTO;
import com.example.Vehicle_Workshop.services.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api"))
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping("/SalesContract/{id}")
    public ResponseEntity<SalesContractDTO> getSalesContractById(@PathVariable Long id){
        return new ResponseEntity<>(contractService.getSalesContractById(id), HttpStatus.OK);
    }

    @PostMapping("/SalesContract")
    public ResponseEntity<SalesContractDTO> createSalesContract(@Valid @RequestBody SalesContractDTO dto){
        var createdContract = contractService.createSalesContract(dto);

        return new ResponseEntity<>(createdContract,HttpStatus.OK);
    }

    @GetMapping("/LeaseContract/{id}")
    public ResponseEntity<LeaseContractDTO> getLeaseContractById(@PathVariable Long id){
        return new ResponseEntity<>(contractService.getLeaseContractById(id), HttpStatus.OK);
    }

    @PostMapping("/LeaseContract")
    public ResponseEntity<LeaseContractDTO> createLeaseContract(@Valid @RequestBody LeaseContractDTO dto){
        var leaseContract = contractService.createLeaseContract(dto);

        return new ResponseEntity<>(leaseContract, HttpStatus.OK);
    }
}
