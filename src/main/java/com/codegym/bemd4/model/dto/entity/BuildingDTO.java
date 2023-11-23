package com.codegym.bemd4.model.dto.entity;

import com.codegym.bemd4.model.entity.building.Address;
import com.codegym.bemd4.model.entity.person.Landlord;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class BuildingDTO {

    private Long id;
    private String buildingName;
    private Long addressId;
    private Long landlordId;
}
