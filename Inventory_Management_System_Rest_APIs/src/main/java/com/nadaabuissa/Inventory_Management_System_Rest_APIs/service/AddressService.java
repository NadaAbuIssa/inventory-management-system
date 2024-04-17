package com.nadaabuissa.Inventory_Management_System_Rest_APIs.service;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    Address createAddress(Address address);

    Address updateAddress(Long id, Address address);

    void deleteAddress(Long id);
}