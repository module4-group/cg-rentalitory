package com.codegym.bemd4.controller;

import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.entity.BuildingDTO;
import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.entity.building.Apartment;
import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/buildings")
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<BuildingDTO>> getBuilding() {
        List<BuildingDTO> BuildingDTOs = buildingService.getBuilding();
        if (BuildingDTOs.isEmpty()) {
            return new ResponseEntity<List<BuildingDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(BuildingDTOs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Building> createBuilding(@RequestBody BuildingDTO buildingDTO) {
        if (buildingDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Building building = buildingService.createBuilding(buildingDTO);
        return new ResponseEntity<>(building, HttpStatus.CREATED);
        // 1 building chỉ có 1 address và 1 landlord
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BuildingDTO> deleteBuilding(@PathVariable Long id) {
        BuildingDTO building = buildingService.getBuildingById(id);

        if (building == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        buildingService.remove(id);
        return new ResponseEntity<>(building, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BuildingDTO>> searchBuilding(
            @RequestParam("buildingName")String buildingName){
        List<BuildingDTO> buildings = buildingService.searchBuildingsByNameContains(buildingName);
        return ResponseEntity.ok(buildings);
    }
}
