package edu.miu.cs.cs489.project.healthinsuranceapp.controller;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Customer;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Address;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.CustomerService;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.imp.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping(value = "/list")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }
    @GetMapping(value = "/get/{customerId}")
    public  Customer getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @PutMapping(value = "/update/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }
    @DeleteMapping(value = "/delete/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }
    @PostMapping(value = "/new")
    public Customer addNewCustomer(Customer customer){
        return customerService.addNewCustomer(customer);
    }
}
