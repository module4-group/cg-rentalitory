package com.codegym.bemd4.model.entity.building;

import com.codegym.bemd4.model.entity.person.Landlord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apartment_name", length = 56, nullable = false)
    private String name;
    @Column(name = "room_number", length = 10, nullable = false)
    private String roomNumber;
    @Column(name = "area", nullable = false)
    private Long area;
    @Column(name = "number_of_bedroom", nullable = false)
    private Long numberOfBedroom;
    @Column(name = "number_of_room", nullable = false)
    private Long numberOfRoom;
    @Column(name = "monthly_rent", nullable = false)
    private Long monthlyRent;
    @Column(name = "max_tenants", nullable = false)
    private Integer maxTenants;
    @Column(name = "activated", nullable = false, columnDefinition = "BIT default true")
    private boolean activated;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id")
    private Building building;
}


