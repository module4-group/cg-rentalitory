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
    private String buildingId;

}
