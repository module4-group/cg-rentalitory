package com.codegym.bemd4.controller;


import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.request.ApartmentRequestDTO;
import com.codegym.bemd4.model.dto.response.ApartmentResponse;
import com.codegym.bemd4.model.dto.response.ApartmentResponseDTO;
import com.codegym.bemd4.model.entity.building.Apartment;
import com.codegym.bemd4.model.entity.person.Landlord;
import com.codegym.bemd4.model.service.ApartmentService;
import com.codegym.bemd4.model.service.LandlordService;
import com.codegym.bemd4.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartments")
@CrossOrigin("*")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;




    @GetMapping
    public ResponseEntity<ApartmentResponse> getApartments(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "50", required = false) int pageSize
    ) {

        ApartmentResponse apartments = apartmentService.getApartments(pageNo, pageSize);
        if (apartments == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(apartments, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Apartment> createApartment(@RequestBody ApartmentRequestDTO apartmentRequestDTO) {
        if (apartmentRequestDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Apartment newApartment = apartmentService.create(apartmentRequestDTO);
        return new ResponseEntity<>(newApartment, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApartmentDTO> getApartmentById(@PathVariable Long id) {
        return new ResponseEntity<>(apartmentService.getApartmentById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Apartment> updateApartment(@PathVariable Long id, @RequestBody ApartmentRequestDTO apartmentDTO) {
        ApartmentRequestDTO apartment = apartmentService.getApartmentRequestDTOById(id);
        if (apartmentDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        apartmentDTO.setId(apartment.getId());

        return new ResponseEntity<>(apartmentService.update(apartmentDTO), HttpStatus.OK);

    }

    @PutMapping("covert/{id}")
    public ResponseEntity<Apartment> convertApartment(@PathVariable Long id) {
        ApartmentRequestDTO apartment = apartmentService.getApartmentRequestDTOById(id);
//        if (apartmentDTO == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        apartmentDTO.setId(apartment.getId());
//
//        return new ResponseEntity<>(apartmentService.convert(apartmentDTO), HttpStatus.OK);
    return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Apartment> deleteApartment(@PathVariable Long id) {
        Optional<ApartmentDTO> apartmentOptional = Optional.ofNullable(apartmentService.getApartmentById(id));
        if (!apartmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        apartmentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Apartment>> searchApartmentsByCityAndDistrict(
            @RequestParam("city") String city,
            @RequestParam(value = "district", defaultValue = "") String district) {

        List<Apartment> apartments = apartmentService.searchApartmentsByCityAndDistrict(city, district);
        return ResponseEntity.ok(apartments);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<ApartmentDTO>> filterBuildingByPrice(
            @RequestParam(name = "maxMonthlyRent", required = false) Long maxMonthlyRent,
            @RequestParam(name = "minMonthlyRent", required = false) Long minMonthlyRent,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "monthlyRent") String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        List<ApartmentDTO> filterResults = apartmentService.filterApartmentByMonthlyRent(minMonthlyRent, maxMonthlyRent, pageable);

        return new ResponseEntity<>(filterResults, HttpStatus.OK);
    }
}
