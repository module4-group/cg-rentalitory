package com.codegym.bemd4.controller;

import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.entity.person.User;
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
    UserService landlordService;

//    @GetMapping
//    public ResponseEntity<List<UserDTO>> getUsers() {
//        List<UserDTO> UserDTOs = landlordService.getUsers();
//        if (UserDTOs.isEmpty()) {
//            return new ResponseEntity<List<UserDTO>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(UserDTOs, HttpStatus.OK);
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<UserDTO> register(@RequestBody UserDTO user) {
//
//        if (user==null){
//            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
//        UserDTO user = userService.getUserById(id);
//
//        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        userService.remove(id);
//        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
//    }
}
