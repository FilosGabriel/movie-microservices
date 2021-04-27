package com.filos.users.repository.model;

import java.time.Instant;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document
public class BasicInformation {
    @Indexed
    private String username;
    private String firstName;
    private String lastName;
    private Instant dateOfBirth;
}
