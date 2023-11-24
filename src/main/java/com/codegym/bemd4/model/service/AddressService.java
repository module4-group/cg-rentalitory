package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.AddressDTO;
import com.codegym.bemd4.model.dto.entity.UserDTO;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAddress();
    AddressDTO getAddressById(Long addressId);
    AddressDTO createAddress(AddressDTO addressDTO);
    AddressDTO remove(Long id);
    AddressDTO update(Long id);
}
