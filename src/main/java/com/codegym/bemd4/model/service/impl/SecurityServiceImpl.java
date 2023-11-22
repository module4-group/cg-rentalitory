//package com.codegym.bemd4.model.service.impl;
//
//
//import com.codegym.casemodule4.model.service.SecurityService;
//import com.codegym.casemodule4.security.JwtTokenProvider;
//import jakarta.transaction.Transactional;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//@Service @Transactional
//public class SecurityServiceImpl implements SecurityService {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public SecurityServiceImpl(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null
//                || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
//            return false;
//        }
//        return authentication.isAuthenticated();
//    }
//
//    @Override
//    public boolean isValidToken(String authToken) {
//        String jwt = jwtTokenProvider.getJwtFromBearerToken(authToken);
//        if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(authToken)) {
//            return true;
//        }
//        return false;
//    }
//}
