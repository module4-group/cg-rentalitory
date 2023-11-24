package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.AddressDTO;
import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.dto.response.ApartmentResponse;
import com.codegym.bemd4.model.entity.building.Apartment;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ApartmentService {

    ApartmentResponse getApartments(int pageNo, int pageSize);
    ApartmentDTO getApartmentById(Long apartmentId);
    Apartment save(Apartment Apartment);
    ApartmentDTO remove(Long id);
    List<Apartment> searchApartmentsByCity(String city);
    List<Apartment> searchApartmentsByCityAndDistrict(String city, String district);
    List<ApartmentDTO> filterApartmentByMonthlyRent(Long minMonthlyRent, Long maxMonthlyRent, Pageable pageable);
}
