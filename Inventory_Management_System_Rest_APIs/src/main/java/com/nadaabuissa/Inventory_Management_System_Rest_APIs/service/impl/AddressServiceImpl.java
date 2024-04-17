package com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.impl;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Address;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.repository.AddressRepository;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setStreet(address.getStreet());
            existingAddress.setCity(address.getCity());
            existingAddress.setState(address.getState());
            existingAddress.setCountry(address.getCountry());
            return addressRepository.save(existingAddress);
        }
        return null;
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}