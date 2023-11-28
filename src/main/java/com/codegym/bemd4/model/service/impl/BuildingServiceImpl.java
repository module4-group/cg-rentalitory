package com.codegym.bemd4.model.service.impl;

import com.codegym.bemd4.model.dto.entity.BuildingDTO;

import com.codegym.bemd4.model.entity.building.Address;
import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.entity.person.Landlord;

import com.codegym.bemd4.model.repository.IAddressRepository;
import com.codegym.bemd4.model.repository.IBuildingRepository;
import com.codegym.bemd4.model.repository.ILandlordRepository;
import com.codegym.bemd4.model.service.BuildingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private final IBuildingRepository buildingRepository;
    @Autowired
    private final IAddressRepository addressRepository;
    @Autowired
    private final ILandlordRepository landlordRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<BuildingDTO> getBuilding() {
        Iterable<Building> buildingsEntities = buildingRepository.findAll();
        return StreamSupport.stream(buildingsEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, BuildingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BuildingDTO getBuildingById(Long buildingId) {
        Building building = buildingRepository.findById(buildingId).orElse(null);
        return modelMapper.map(building, BuildingDTO.class);
    }

    @Override
    public Building createBuilding(BuildingDTO buildingDTO) {
        Building building = modelMapper.map(buildingDTO, Building.class);
        building.setActivated(true);

        Address address = addressRepository.findAddressById(buildingDTO.getAddressId());
        Landlord landlord = landlordRepository.findLandlordById(buildingDTO.getLandlordId());

        building.setAddress(address);
        building.setLandlord(landlord);

        buildingRepository.save(building);
        return building;
    }


    @Override
    public BuildingDTO remove(Long id) {
        Building building = buildingRepository.findBuildingById(id);
        if (building == null) {
            return null;
        }
        building.setActivated(false);
        building = buildingRepository.save(building);
        BuildingDTO removedDTO = modelMapper.map(building, BuildingDTO.class);
        return removedDTO;
    }

    @Override
    public Building update(BuildingDTO buildingDTO) {
        Building building = modelMapper.map(buildingDTO, Building.class);
        return buildingRepository.save(building);
    }

//    @Override
//    public List<BuildingDTO> searchBuildingsByNameContains(String name) {
//        List<Building> buildingEntities= buildingRepository.findByNameContainsIgnoreCase(name);
//        return StreamSupport.stream(buildingEntities.spliterator(), true)
//                .map(entity -> modelMapper.map(entity, BuildingDTO.class))
//                .collect(Collectors.toList());
//    }

    public List<BuildingDTO> searchBuildingsByNameContains(String buildingName) {
        List<Building> buildingEntities= buildingRepository.findByBuildingNameContainsIgnoreCase(buildingName);
        return StreamSupport.stream(buildingEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, BuildingDTO.class))
                .collect(Collectors.toList());
    }
}
