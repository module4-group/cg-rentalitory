package com.codegym.bemd4.model.service;

import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.entity.person.Landlord;

import java.util.List;

public interface LandlordService {
    List<LandlordDTO> getLandlord();
    LandlordDTO getLandlordById(Long landlordId);
    LandlordDTO registerLandlord(LandlordDTO landlordDTO);
    LandlordDTO remove(Long id);
    Landlord update(LandlordDTO landlordDTO);
    Landlord getLandlordFromToken(String token);
    List<LandlordDTO> searchLandlordsByFullNameContains(String fullName);

}
