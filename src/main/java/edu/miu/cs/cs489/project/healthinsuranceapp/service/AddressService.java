package edu.miu.cs.cs489.project.healthinsuranceapp.service;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Address;
import edu.miu.cs.cs489.project.healthinsuranceapp.model.Customer;

import java.util.List;

public interface AddressService {
    public List<Address> getAllAddresses();
    public Address getAddressById(Long addressId);
    public Address updateAddress(Long addressId, Address address);
    public void deleteCustomerAddressById(Long customerId);
    public void deleteAddressById(Long addressId);
    public Address addNewAddress(Address address);
}
