package edu.miu.cs.cs489.project.healthinsuranceapp.service.imp;

import edu.miu.cs.cs489.project.healthinsuranceapp.model.Address;
import edu.miu.cs.cs489.project.healthinsuranceapp.repository.AddressRepository;
import edu.miu.cs.cs489.project.healthinsuranceapp.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }
    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .orElse(null);
    }

    @Override
    public Address updateAddress(Long addressId, Address address) {
//        Address currentAddress = addressRepository.findById(addressId);
//        Address updatedAddress = new Address(currentAddress.setStreet(address.getStreet()), currentAddress.setCity(address.getCity()),
//                currentAddress.setState(address.getState()), currentAddress.setZipcode(address.getZipcode()));
        return addressRepository.save(address);
    }

    @Override
    public void deleteCustomerAddressById(Long customerId) {
        addressRepository.deleteById(customerId);
    }

    @Override
    public void deleteAddressById(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public Address addNewAddress(Address address) {
        return addressRepository.save(address);
    }
}
