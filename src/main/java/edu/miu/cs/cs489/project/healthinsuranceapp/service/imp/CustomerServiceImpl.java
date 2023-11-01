package edu.miu.cs.cs489.project.healthinsuranceapp.service.imp;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Customer;
import edu.miu.cs.cs489.project.healthinsuranceapp.repository.CustomerRepository;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElse(null);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
