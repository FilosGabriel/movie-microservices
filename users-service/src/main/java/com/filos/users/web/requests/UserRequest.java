package com.filos.users.web.requests;

import lombok.Data;

@Data
public class UserRequest {
    private final String email;
    private final String method;
}
