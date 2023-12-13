package com.codegym.bemd4.controller;

import com.codegym.bemd4.model.dto.entity.BuildingDTO;
import com.codegym.bemd4.model.dto.request.CreateBuildingRequestDTO;
import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/buildings")
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    @GetMapping
    public ResponseEntity<List<Building>> getBuilding() {
        List<Building> building = buildingService.getBuilding();
        if (building.isEmpty()) {
            return new ResponseEntity<List<Building>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(building, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBuilding(@RequestBody CreateBuildingRequestDTO createBuildingRequestDTO) {
        if (createBuildingRequestDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Building building = buildingService.createBuilding(createBuildingRequestDTO);
        return new ResponseEntity<>("tạo thành công", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Building> updateBuilding(@PathVariable Long id, @RequestBody BuildingDTO buildingDTO) {
        BuildingDTO building = buildingService.getBuildingById(id);
        if (building == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        buildingDTO.setId(building.getId());
        buildingDTO.setActivated(true);
        return new ResponseEntity<>(buildingService.update(buildingDTO), HttpStatus.OK);
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
            @RequestParam("buildingName") String buildingName) {
        List<BuildingDTO> buildings = buildingService.searchBuildingsByNameContains(buildingName);
        return ResponseEntity.ok(buildings);
    }
}
