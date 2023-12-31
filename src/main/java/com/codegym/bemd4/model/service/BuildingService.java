package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.BuildingDTO;
import com.codegym.bemd4.model.dto.request.CreateBuildingRequestDTO;
import com.codegym.bemd4.model.entity.building.Building;

import java.util.List;

public interface BuildingService {

    List<Building> getBuilding();
    BuildingDTO getBuildingById(Long buildingId);
    Building createBuilding(CreateBuildingRequestDTO createBuildingRequestDTO);
    BuildingDTO remove(Long id);

    Building update(BuildingDTO buildingDTO);

    List<BuildingDTO> searchBuildingsByNameContains(String name);
}
