package com.codegym.bemd4.model.dto.response;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String message;
    private String token;
    private boolean isAdmin;

    public LoginResponseDTO(String message, String token, boolean isAdmin) {
        this.message = message;
        this.token = token;
        this.isAdmin = isAdmin;
    }
}
