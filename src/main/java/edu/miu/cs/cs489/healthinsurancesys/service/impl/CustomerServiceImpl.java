package edu.miu.cs.cs489.healthinsurancesys.service.impl;

import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerRequest;
import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerResponse;
import edu.miu.cs.cs489.healthinsurancesys.model.Customer;
import edu.miu.cs.cs489.healthinsurancesys.repository.CustomerRepository;
import edu.miu.cs.cs489.healthinsurancesys.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerResponse addNewCustomer(CustomerRequest customerRequest) {
        Customer newCustomer = new Customer(customerRequest.firstName(), customerRequest.lastName());
        customerRepository.save(newCustomer);
        return new CustomerResponse(newCustomer.getCustomerId(), newCustomer.getFirstName(), newCustomer.getLastName());
    }

    @Override
    public List<CustomerResponse> getAllCustomers(){
        return customerRepository.findAll().stream()
                .map(c -> new CustomerResponse(c.getCustomerId(), c.getFirstName(), c.getLastName())).toList();
    }

    public Boolean deleteCustomer(int customerId) {
        customerRepository.findById(customerId).ifPresent(customerRepository::delete);
        return true;
    }
}
