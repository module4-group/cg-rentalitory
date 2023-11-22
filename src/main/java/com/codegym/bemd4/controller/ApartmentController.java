package com.codegym.bemd4.controller;


import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
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
@RequestMapping("/api")
@CrossOrigin("*")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/apartments")
    public ResponseEntity<Iterable<ApartmentDTO>> getApartments(){
        List<ApartmentDTO> apartments= apartmentService.getApartments();
        return new ResponseEntity<>(apartments,HttpStatus.OK);
    }



}
