package com.filos.users.web.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserResetRequest {
    @NotBlank
    private final String contact;
}
