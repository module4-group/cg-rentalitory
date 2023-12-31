package com.codegym.bemd4.model.entity.building;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="city")
    @NotBlank
    private String city;
    @Column(name="district")
    @NotBlank
    private String district;
    @Column(name="house_number")
    @NotBlank
    private String houseNumber;
    @Column(name="ward")
    @NotBlank
    private String ward;
    @Column(name = "activated", nullable = false, columnDefinition = "BIT default true")
    private Boolean activated;

    public Address(String city, String district, String houseNumber, String ward, Boolean activated) {
        this.city = city;
        this.district = district;
        this.houseNumber = houseNumber;
        this.ward = ward;
        this.activated = activated;
    }
}