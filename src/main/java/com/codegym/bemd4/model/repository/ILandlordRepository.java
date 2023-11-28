package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import com.codegym.bemd4.model.entity.person.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ILandlordRepository extends JpaRepository<Landlord,Long> {
    Landlord findLandlordById(Long id);

    Landlord findLandlordByUsername(String username);

    Landlord findLandlordByEmail(String email);
    List<Landlord> findByFullNameContainsIgnoreCase(String fullName);

    List<Landlord> findByUsernameContainsIgnoreCase(String name);

    @Query("SELECT r.name FROM Role r JOIN r.landlords l WHERE l.username = :username")
    List<String> findRolesNamesByUsername(@Param("username") String username);

    boolean existsByUsername(String username);


}