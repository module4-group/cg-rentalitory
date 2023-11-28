package com.codegym.bemd4.model.dto.entity;

import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.entity.person.Landlord;
import lombok.Data;

@Data
public class ApartmentDTO {
    private Long id;
    private String name;
    private Long roomNumber;
    private Long area;
    private Long numberOfBedroom;
    private Long numberOfRoom;
    private Long monthlyRent;
    private Integer maxTenants;
    private Boolean activated;
    private Building building;
}
