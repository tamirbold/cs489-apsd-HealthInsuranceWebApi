package edu.miu.cs.cs489.healthinsurancesys.controller;

import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerRequest;
import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerResponse;
import edu.miu.cs.cs489.healthinsurancesys.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/insurance/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){

        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @PostMapping(value = "/register")
    public ResponseEntity<CustomerResponse> getAllPrimePolicies(@Valid @RequestBody CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.addNewCustomer(customerRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{customerId}")
    public Boolean deleteCustomer(@PathVariable int customerId){
        return customerService.deleteCustomer(customerId);
    }

}
