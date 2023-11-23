package com.codegym.bemd4.controller;

import com.codegym.bemd4.model.dto.entity.AddressDTO;
import com.codegym.bemd4.model.dto.entity.BuildingDTO;
import com.codegym.bemd4.model.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAddress(){
        List<AddressDTO> AddressDTOs = addressService.getAddress();
        if (AddressDTOs.isEmpty()){
            return new ResponseEntity<List<AddressDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(AddressDTOs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO ){
        if (addressDTO==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressService.createAddress(addressDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> deleteAddress(@PathVariable Long id) {
        AddressDTO address = addressService.getAddressById(id);

        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressService.remove(id);
        return new ResponseEntity<>(address, HttpStatus.NO_CONTENT);
    }
}