package com.codegym.bemd4.model.service.impl;

import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.request.ApartmentRequestDTO;
import com.codegym.bemd4.model.dto.response.ApartmentResponse;
import com.codegym.bemd4.model.entity.building.Apartment;
import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.repository.IApartmentRepository;
import com.codegym.bemd4.model.repository.IBuildingRepository;
import com.codegym.bemd4.model.service.ApartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    private final IApartmentRepository apartmentRepository;
    @Autowired
    private final IBuildingRepository buildingRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApartmentResponse getApartments(int pageNo,int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Apartment> apartmentEntities = apartmentRepository.findAll(pageable);

        List<Apartment> apartments = apartmentEntities.getContent();

        List<ApartmentDTO> content = StreamSupport.stream(apartments.spliterator(), true)
                .map(entity -> modelMapper.map(entity, ApartmentDTO.class))
                .collect(Collectors.toList());

        ApartmentResponse apartmentResponse = new ApartmentResponse();
        apartmentResponse.setContent(content);
        apartmentResponse.setPageNo(apartmentEntities.getNumber());
        apartmentResponse.setPageSize(apartmentEntities.getSize() );
        apartmentResponse.setTotalElements(apartmentEntities.getTotalElements());
        apartmentResponse.setTotalPages(apartmentEntities.getTotalPages());
        apartmentResponse.setLast(apartmentEntities.isLast());
        return apartmentResponse;
    }
    @Override
    public List<ApartmentDTO> getAllApartments() {
        Iterable<Apartment> apartmentEntities = apartmentRepository.findAll();
        return StreamSupport.stream(apartmentEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, ApartmentDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public ApartmentDTO getApartmentById(Long apartmentId) {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElse(null);
        return modelMapper.map(apartment, ApartmentDTO.class);
    }

    @Override
    public ApartmentDTO remove(Long id) {
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        if (apartment == null) {
            return null;
        }
        apartment.get().setActivated(false);
        apartmentRepository.save(apartment.get());
        ApartmentDTO apartmentDTO = modelMapper.map(apartment, ApartmentDTO.class);
        return apartmentDTO;
    }
    @Override
    public Apartment create(ApartmentRequestDTO apartmentRequestDTO) {
        Apartment apartment = modelMapper.map(apartmentRequestDTO,Apartment.class);
        apartment.setActivated(true);
        Building building = buildingRepository.findBuildingById(apartmentRequestDTO.getBuildingId());

        apartment.setBuilding(building);

        apartmentRepository.save(apartment);
        return apartment;
    }

    @Override
    public List<Apartment> searchApartmentsByCity(String city) {
        return apartmentRepository.findAllByCity(city);
    }
    @Override
    public List<Apartment> searchApartmentsByCityAndDistrict(String city, String district) {
        return apartmentRepository.findAllByCityAndDistrict(city, district);
    }

}
