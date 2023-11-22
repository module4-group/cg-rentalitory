package com.codegym.bemd4.model.dto.entity;

import lombok.Data;

@Data
public class ApartmentDTO {
    private Long id;
    private String roomNumber;
    private Long area;
    private Long numberOfBedRooms;
    private Long monthlyRent;
    private Integer maxTenants;
    private Long buildingId;
}
