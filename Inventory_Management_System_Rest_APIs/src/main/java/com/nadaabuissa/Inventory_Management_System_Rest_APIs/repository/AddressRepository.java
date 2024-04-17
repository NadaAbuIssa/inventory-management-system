package com.nadaabuissa.Inventory_Management_System_Rest_APIs.repository;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}