package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.person.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByName(String name);
}
