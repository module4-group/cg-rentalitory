//package com.codegym.bemd4.model.service.impl;
//
//import com.codegym.bemd4.model.entity.person.User;
//import com.codegym.bemd4.model.repository.IUserRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service @RequiredArgsConstructor @Transactional
//public class UserDetailsServiceImpl {
//    @Autowired
//    private final IUserRepository userRepo;
//
//    public UserDetails loadUserByUsername(String username) {
//        User user = userRepo.findUserByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + username + "was not found in database!");
//        }
//
//        List<String> roles = userRepo.findRolesByUsername(username);
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (String role: roles) {
//            GrantedAuthority authority = new SimpleGrantedAuthority(role);
//            grantedAuthorities.add(authority);
//        }
//
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                grantedAuthorities);
//
//        return userDetails;
//    }
//
//}
//
