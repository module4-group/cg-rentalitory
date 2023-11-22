package com.codegym.bemd4.model.entity.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotBlank
    @Column(name = "description", length = 100, nullable = false)
    private String desc;
}