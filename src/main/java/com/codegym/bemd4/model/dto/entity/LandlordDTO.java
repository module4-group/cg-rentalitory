package com.codegym.bemd4.model.dto.entity;

import com.codegym.bemd4.model.entity.building.Address;
import lombok.Data;

import java.util.List;

@Data
public class LandlordDTO {
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private String avatar;
    private List<ApartmentDTO> apartments;
}
