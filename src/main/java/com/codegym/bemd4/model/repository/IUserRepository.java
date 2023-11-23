package com.codegym.bemd4.model.repository;

import com.codegym.bemd4.model.entity.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserById(Long userId);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    @Query("SELECT r.name FROM Role r " +
            "JOIN User u " +
            "WHERE u.username = :username")
    List<String> findRolesByUsername(@Param("username") String username);

    List<User> findByUsernameContainsIgnoreCase(String username);
}
