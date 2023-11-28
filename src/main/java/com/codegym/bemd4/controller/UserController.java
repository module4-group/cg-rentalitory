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
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> UserDTOs = userService.getUsers();
        if (UserDTOs.isEmpty()) {
            return new ResponseEntity<List<UserDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(UserDTOs, HttpStatus.OK);
    }

    @PutMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {

        if (userDTO==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.registerUser(userDTO), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {

        if (userDTO==null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.update(userDTO), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> searchUsersByName(
            @RequestParam String name
    ) {
        return ResponseEntity.ok(userService.searchUsersByNameContains(name));
    }

}
