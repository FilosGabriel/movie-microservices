package com.filos.requests.users;

import lombok.Data;

@Data
public class FindUser {
    private final String username;
    private final String email;
}
