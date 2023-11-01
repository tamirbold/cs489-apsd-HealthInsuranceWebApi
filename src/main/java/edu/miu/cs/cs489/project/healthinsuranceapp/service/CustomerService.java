package edu.miu.cs.cs489.project.healthinsuranceapp.service;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Customer;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Address;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomer();
    public Customer getCustomerById(Long customerId);
    public Customer updateCustomer(Long customerId, Customer customer);
    public void deleteCustomerById(Long customerId);
    public Customer addNewCustomer(Customer customer);
}
