package com.codegym.bemd4.model.entity.building;

import com.codegym.bemd4.model.entity.person.Landlord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "buildings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buildingName;
    @OneToOne
    private Address address;
    @OneToOne
    private Landlord landlord;
    @Column(name = "activated", nullable = true)
    private Boolean activated;


}
