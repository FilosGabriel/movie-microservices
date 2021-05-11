package com.filos.users.web.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private final String username;
    @NotBlank
    private final String password;
    @NotBlank
    private final String method;
    private final String data;
}
