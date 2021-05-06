package com.filos.users.repository.model;

import java.time.Instant;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document
public class BasicInformation {
    @Indexed
    private @NonNull String username;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull Instant dateOfBirth;
}
