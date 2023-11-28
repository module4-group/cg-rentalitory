package com.codegym.bemd4.model.dto.request;

import com.codegym.bemd4.model.entity.building.Address;
import com.codegym.bemd4.model.entity.person.Landlord;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class CreateBuildingRequestDTO {
    private String buildingName;
    private String city;
    private String district;
    private String ward;
    private String houseNumber;
    private boolean activated;
    private Long landlordId;
}
