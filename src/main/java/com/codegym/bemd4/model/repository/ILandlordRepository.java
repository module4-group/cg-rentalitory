package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.person.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord,Long> {
    Landlord findLandlordById(Long id);


    Landlord findLandlordByEmail(String email);

    List<Landlord> findByUsernameContainsIgnoreCase(String name);
    @Query("SELECT r.name FROM Role r JOIN r.landlords l WHERE l.username = :username")
    List<String> findRolesNamesByUsername(@Param("username") String username);

    List<Landlord> findByFullNameContainsIgnoreCase(String fullName);
}
