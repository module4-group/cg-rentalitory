package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.entity.building.Apartment;

import java.util.List;

public interface ApartmentService {
    List<ApartmentDTO> getApartments();
    ApartmentDTO getApartmentById(Long apartmentId);
    Apartment save(Apartment Apartment);
    ApartmentDTO remove(Long id);
}
