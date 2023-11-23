package com.codegym.bemd4.model.dto.entity;

import lombok.Data;

@Data
public class ApartmentDTO {
    private Long id;
    private String name;
    private String roomNumber;
    private String numberOfRoom;
    private Long area;
    private Long numberOfBedRoom;
    private Long numberOfRoom;
    private Long monthlyRent;
    private Integer maxTenants;
    private Long buildingId;
}
