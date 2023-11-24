package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.building.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findAllByNameContainsIgnoreCase(String name);
}
