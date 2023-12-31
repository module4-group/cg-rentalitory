package com.codegym.bemd4.model.service.impl;

import com.codegym.bemd4.model.dto.entity.BuildingDTO;

import com.codegym.bemd4.model.dto.request.CreateBuildingRequestDTO;
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
    public List<Building> getBuilding() {
        Iterable<Building> buildingsEntities = buildingRepository.findAll();
        return StreamSupport.stream(buildingsEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, Building.class))
                .collect(Collectors.toList());
    }

    @Override
    public BuildingDTO getBuildingById(Long buildingId) {
        Building building = buildingRepository.findById(buildingId).orElse(null);
        return modelMapper.map(building, BuildingDTO.class);
    }

    @Override
    public Building createBuilding(CreateBuildingRequestDTO createBuildingRequestDTO) {

        Address address = new Address(createBuildingRequestDTO.getCity(),createBuildingRequestDTO.getDistrict(),createBuildingRequestDTO.getWard(),createBuildingRequestDTO.getHouseNumber(),true);
        addressRepository.save(address);


        Building building = new Building(createBuildingRequestDTO.getBuildingName(), true);
        Landlord landlord = landlordRepository.findLandlordById(createBuildingRequestDTO.getLandlordId()) ;

        building.setActivated(true);

        building.setAddress(address);
        landlord.getBuildings().add(building);
        building.setLandlord(landlord);
        landlordRepository.save(landlord);
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


    public List<BuildingDTO> searchBuildingsByNameContains(String buildingName) {
        List<Building> buildingEntities= buildingRepository.findByBuildingNameContainsIgnoreCase(buildingName);
        return StreamSupport.stream(buildingEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, BuildingDTO.class))
                .collect(Collectors.toList());
    }
}
