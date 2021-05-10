package com.filos.users.web.requests;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private final String password;
    private final String passwordConfirm;
    private final String email;
}
