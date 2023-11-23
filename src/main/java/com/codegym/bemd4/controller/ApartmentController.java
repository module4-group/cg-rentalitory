package com.codegym.bemd4.controller;


import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.response.ApartmentResponse;
import com.codegym.bemd4.model.entity.building.Apartment;
import com.codegym.bemd4.model.entity.person.User;
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

    @GetMapping
    public ResponseEntity<ApartmentResponse> getApartments(
            @RequestParam(value = "pageNo", defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10",required = false) int pageSize
    ) {
        ApartmentResponse apartments = apartmentService.getApartments(pageNo,pageSize);
        return new ResponseEntity<>(apartments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        return new ResponseEntity<>(apartmentService.save(apartment),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Apartment> updateApartment(@PathVariable Long id, @RequestBody Apartment apartment) {
        Optional<ApartmentDTO> apartmentOptional = Optional.ofNullable(apartmentService.getApartmentById(id));
        if (!apartmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        apartment.setId(apartmentOptional.get().getId());
        return new ResponseEntity<>(apartmentService.save(apartment), HttpStatus.OK);
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


}
