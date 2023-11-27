package com.codegym.bemd4.model.dto.entity;

import lombok.Data;

@Data
public class BuildingDTO {

    private Long id;
    private String buildingName;
    private Boolean activated;
    private Long addressId;
    private Long landlordId;
}
