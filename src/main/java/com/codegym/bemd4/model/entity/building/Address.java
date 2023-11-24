package com.codegym.bemd4.model.entity.building;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name="city") @NotBlank
    private String city;
    @Column(name="district") @NotBlank
    private String district;
    @Column(name="house_number") @NotBlank
    private String houseNumber;
    @Column(name = "activated", nullable = true,columnDefinition = "BIT default true")
    private Boolean activated;

}
