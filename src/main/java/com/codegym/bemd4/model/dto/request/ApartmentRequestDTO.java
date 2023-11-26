package com.codegym.bemd4.model.dto.request;

import com.codegym.bemd4.model.entity.building.Building;
import lombok.Data;

@Data
public class ApartmentRequestDTO {
    private String name;
    private Long roomNumber;
    private Long area;
    private Long numberOfBedroom;
    private Long numberOfRoom;
    private Long monthlyRent;
    private Integer maxTenants;
    private String buildingName;
    private String city;
    private String district;
    private String ward;
    private String houseNumber;
    private String roles;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private String avatar;
}
