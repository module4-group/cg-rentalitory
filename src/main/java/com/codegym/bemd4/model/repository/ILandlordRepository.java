package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.person.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord,Long> {
}
