package com.codegym.bemd4.controller;

import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.entity.person.User;
import com.codegym.bemd4.model.service.LandlordService;
import com.codegym.bemd4.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/landlord")
public class LandlordController {
    @Autowired
    LandlordService landlordService;

    @GetMapping
    public ResponseEntity<List<LandlordDTO>> getUsers() {
        List<LandlordDTO> LandlordDTOs = landlordService.getLandlord();
        if (LandlordDTOs.isEmpty()) {
            return new ResponseEntity<List<LandlordDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(LandlordDTOs, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<LandlordDTO> registerLandlord(@RequestBody LandlordDTO landlordDTO) {

        if (landlordDTO==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(landlordService.registerLandlord(landlordDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LandlordDTO> deleteLandlord(@PathVariable Long id) {
        LandlordDTO landlord = landlordService.getLandlordById(id);

        if (landlord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        landlordService.remove(id);
        return new ResponseEntity<>(landlord, HttpStatus.NO_CONTENT);
    }

}
