package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.BuildingDTO;

import java.util.List;

public interface BuildingService {

    List<BuildingDTO> getBuilding();
    BuildingDTO getBuildingById(Long buildingId);
    BuildingDTO createBuilding(BuildingDTO buildingDTO);
    BuildingDTO remove(Long id);
//    List<BuildingDTO> searchBuildingsByNameContains(String name);
}
