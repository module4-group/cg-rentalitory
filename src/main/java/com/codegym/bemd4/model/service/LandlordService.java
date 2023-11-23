package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import com.codegym.bemd4.model.dto.entity.UserDTO;

import java.util.List;

public interface LandlordService {
    List<LandlordDTO> getLandlord();
    LandlordDTO getLandlordById(Long landlordId);
    LandlordDTO registerLandlord(LandlordDTO landlordDTO);
    LandlordDTO remove(Long id);
    LandlordDTO findLandlordByUsername(String username);
    LandlordDTO findLandlordByEmail(String email);
}
