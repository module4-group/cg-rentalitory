package com.codegym.bemd4.model.entity;

import com.codegym.bemd4.model.entity.person.Landlord;
import com.codegym.bemd4.model.entity.person.User;
import jakarta.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    User user;
    @ManyToOne(fetch = FetchType.EAGER)
    Landlord landlord;

}
