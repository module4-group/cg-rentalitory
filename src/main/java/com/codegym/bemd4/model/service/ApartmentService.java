package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.request.ApartmentRequestDTO;
import com.codegym.bemd4.model.dto.response.ApartmentResponse;
import com.codegym.bemd4.model.entity.building.Apartment;

import java.util.List;

public interface ApartmentService {

    ApartmentResponse getApartments(int pageNo, int pageSize);
    List<ApartmentDTO> getAllApartments();
    ApartmentDTO getApartmentById(Long apartmentId);
    Apartment create(ApartmentRequestDTO apartmentRequestDTO);

    ApartmentDTO remove(Long id);
    List<Apartment> searchApartmentsByCity(String city);
    List<Apartment> searchApartmentsByCityAndDistrict(String city, String district);
}
