package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.person.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord,Long> {
    Landlord findLandlordById(Long id);

//    Landlord findLandlordByUsername(String username);
//
//    Landlord findLandlordByEmail(String email);

    List<Landlord> findByFullNameContainsIgnoreCase(String fullName);
}
