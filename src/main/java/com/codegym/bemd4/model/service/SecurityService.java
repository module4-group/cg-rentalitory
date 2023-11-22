package com.codegym.bemd4.model.service;

public interface SecurityService {
    boolean isAuthenticated();
    boolean isValidToken(String token);
}
