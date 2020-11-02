package com.filos.users.repository.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
@Setter
@Document
public class User {
    @Id
    private UUID id;
    @Indexed
    private String username;
    @Indexed
    private String email;
    @Indexed
    private String password;
    private String firstName;
    private String lastName;
    private String secret;
    private Instant dateOfBirth;

    @Tolerate
    public User() {
    }
}
