package edu.miu.cs.cs489.healthinsurancesys.service;

import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerRequest;
import edu.miu.cs.cs489.healthinsurancesys.dto.customer.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse addNewCustomer(CustomerRequest customerRequest);
    List<CustomerResponse> getAllCustomers();

    Boolean deleteCustomer(int customerId);
}
