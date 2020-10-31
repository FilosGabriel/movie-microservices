package com.filos.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
@Setter
public class User {
    private UUID id;
    private String username;
    private Instant dateOfBirth;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
