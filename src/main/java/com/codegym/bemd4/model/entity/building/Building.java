package com.codegym.bemd4.model.entity.building;

import com.codegym.bemd4.model.entity.person.Landlord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "buildings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "building_name", length = 200, nullable = false, unique = true)
    private String buildingName;
    @OneToOne
    @JoinColumn(name="address_id")
    Address address;

    @ManyToOne
    @JoinColumn(name="landlord_id")
    Landlord landlord;

    @Column(name = "activated", nullable = false, columnDefinition = "BIT default true")
    private Boolean activated;

    @OneToMany(mappedBy = "building")
    @JsonIgnore
    List<Apartment> apartments;

    public Building(String buildingName, Boolean activated) {
        this.buildingName = buildingName;
        this.activated = activated;
    }
}
