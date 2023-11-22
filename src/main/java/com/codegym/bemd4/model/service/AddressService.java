package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.UserDTO;

import java.util.List;

public interface AddressService {
    List<UserDTO> getUsers();
    UserDTO getUserById(Long userId);
    UserDTO save(UserDTO UserDTO);
    UserDTO remove(Long id);
}
