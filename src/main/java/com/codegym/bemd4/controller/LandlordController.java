package com.codegym.bemd4.controller;

import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import com.codegym.bemd4.model.dto.response.LandlordResponse;
import com.codegym.bemd4.model.entity.person.Landlord;
import com.codegym.bemd4.model.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/landlords")
public class LandlordController {
    @Autowired
    LandlordService landlordService;
    @GetMapping
    public ResponseEntity<LandlordResponse> getUsers(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "50", required = false) int pageSize

    ) {
        LandlordResponse landlordResponse = landlordService.getLandlord(pageNo,pageSize);

        if (landlordResponse == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(landlordResponse, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<LandlordDTO> getLandlordById(@PathVariable Long id) {
        return new ResponseEntity<>(landlordService.getLandlordById(id), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<LandlordDTO> registerLandlord(@RequestBody LandlordDTO landlordDTO) {

        if (landlordDTO==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(landlordService.registerLandlord(landlordDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Landlord> updateLandLord(@RequestBody LandlordDTO landlordDTO,@PathVariable Long id) {
        LandlordDTO landlord = landlordService.getLandlordById(id);
        if (landlordDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        landlordDTO.setId(landlord.getId());
        return new ResponseEntity<>(landlordService.update(landlordDTO), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LandlordDTO> deleteLandlord(@PathVariable Long id) {
        LandlordDTO landlord = landlordService.getLandlordById(id);

        if (landlord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        landlordService.remove(id);
        return new ResponseEntity<>(landlord, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<LandlordDTO>> searchLandlordsByFullName(
            @RequestParam("fullName") String fullName) {

        List<LandlordDTO> landlords  = landlordService.searchLandlordsByFullNameContains(fullName);
        return ResponseEntity.ok(landlords);
    }
}
