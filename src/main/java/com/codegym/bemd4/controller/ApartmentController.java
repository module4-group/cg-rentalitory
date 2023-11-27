package com.codegym.bemd4.controller;


import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.request.ApartmentRequestDTO;
import com.codegym.bemd4.model.dto.response.ApartmentResponse;
import com.codegym.bemd4.model.dto.response.ApartmentResponseDTO;
import com.codegym.bemd4.model.entity.building.Apartment;
import com.codegym.bemd4.model.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

//    @GetMapping
//    public ResponseEntity<List<ApartmentDTO>> getAllApartment() {
//        List<ApartmentDTO> apartmentDTOS = apartmentService.getAllApartments();
//        if (apartmentDTOS.isEmpty()) {
//            return new ResponseEntity<List<ApartmentDTO>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(apartmentDTOS, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<ApartmentResponse> getApartments(
            @RequestParam(value = "pageNo",defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "50", required = false) int pageSize
    ) {
        ApartmentResponse apartments = apartmentService.getApartments(pageNo, pageSize);
        return new ResponseEntity<>(apartments, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Apartment> createApartment(@RequestBody ApartmentRequestDTO apartmentDTO) {
        if (apartmentDTO == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        Apartment newApartment = apartmentService.create(apartmentDTO);
        return new ResponseEntity<>(newApartment,HttpStatus.CREATED);
    }
//    @PutMapping("{id}")
//    public ResponseEntity<Apartment> updateApartment(@PathVariable Long id, @RequestBody ApartmentRequestDTO apartmentRequestDTO) {
//        Optional<ApartmentDTO> apartmentOptional = Optional.ofNullable(apartmentService.getApartmentById(id));
//        if (!apartmentOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        apartment.setId(apartmentOptional.get().getId());
//        return new ResponseEntity<>(apartmentService.create(apartmentRequestDTO), HttpStatus.OK);
//    }
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
            @RequestParam(value = "district", defaultValue = "") String district){

        List<Apartment> apartments = apartmentService.searchApartmentsByCityAndDistrict(city, district);
        return ResponseEntity.ok(apartments);
    }

//    @GetMapping("/sort")

}
