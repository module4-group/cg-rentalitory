package com.codegym.bemd4.model.entity.building;

import com.codegym.bemd4.model.entity.person.Landlord;
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
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;
    @Column(name = "activated", nullable = false, columnDefinition = "BIT default true")
    private Boolean activated;

//    @OneToMany(mappedBy = "building")
//    List<Apartment> apartments;

}
