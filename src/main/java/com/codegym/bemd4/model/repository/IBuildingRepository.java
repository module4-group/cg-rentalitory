package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBuildingRepository extends JpaRepository<Building, Long> {
    Building findBuildingById(Long buildingId);
    List<Building> findByBuildingNameContainsIgnoreCase(String buildingName);
}
