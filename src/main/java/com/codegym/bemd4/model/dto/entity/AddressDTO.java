package com.codegym.bemd4.model.dto.entity;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String city;
    private String district;
    private String ward;
    private String houseNumber;
    private Boolean activated;

}
