package com.codegym.bemd4.model.dto.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String city;
    private String district;
    private String houseNumber;
}