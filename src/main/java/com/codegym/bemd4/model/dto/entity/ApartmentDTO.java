package com.codegym.bemd4.model.dto.entity;

import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.entity.person.Landlord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ApartmentDTO {
    private Long id;
    private String name;
    private String location;
    private String roomNumber;
    private String numberOfRoom;
    private Long area;
    private Long numberOfBedRooms;
    private Long monthlyRent;
    private Integer maxTenants;
    private Long buildingId;
}
