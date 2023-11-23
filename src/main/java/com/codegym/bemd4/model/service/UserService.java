package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.entity.person.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUserById(Long userId);
    UserDTO registerUser(UserDTO UserDTO);
    UserDTO remove(Long id);
    UserDTO findUserByUsername(String username);
    UserDTO findUserByEmail(String email);

    List<UserDTO> searchUsersByNameContains(String name);
}
