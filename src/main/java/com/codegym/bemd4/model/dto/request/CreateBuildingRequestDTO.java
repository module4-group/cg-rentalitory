package com.codegym.bemd4.model.dto.request;

import com.codegym.bemd4.model.entity.building.Address;
import com.codegym.bemd4.model.entity.person.Landlord;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class CreateBuildingRequestDTO {
    private Long id;
    private String buildingName;
    private Address address;
}
