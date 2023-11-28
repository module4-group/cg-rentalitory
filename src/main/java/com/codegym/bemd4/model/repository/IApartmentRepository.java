package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.building.Apartment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApartmentRepository extends JpaRepository<Apartment, Long> {
    List<Apartment> findAllByNameContainsIgnoreCase(String name);
    @Query( "SELECT a FROM Apartment a " +
            "JOIN a.building b " +
            "JOIN b.address ad " +
            "WHERE ad.city LIKE :city" +
            " AND ad.district LIKE :district")
    List<Apartment> findAllByCity(String city);

    @Query( "SELECT a FROM Apartment a " +
            "JOIN a.building b " +
            "JOIN b.address ad " +
            "WHERE ad.city LIKE :city" +
            " AND ad.district LIKE :district")
    List<Apartment> findAllByCityAndDistrict(String city,String district);

    Page<Apartment> findByMonthlyRentBetween(Long minMonthlyRent, Long maxMonthlyRent,Pageable pageable);
    Page<Apartment> findByMonthlyRentGreaterThanEqual(Long minMonthlyRent, Pageable pageable);
    Page<Apartment> findByMonthlyRentLessThanEqual(Long maxMonthlyRent,Pageable pageable);


}
