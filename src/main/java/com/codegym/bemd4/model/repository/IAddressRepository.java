package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.building.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
    Address findAddressById(Long addressId);
}
