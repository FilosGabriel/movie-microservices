package com.filos.users.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
@Getter
@Setter
@Document
public class User {
    @Id
    private String id;
    private @NonNull ContactInformation contactInfo;
    private @NonNull BasicInformation BasicInfo;
    private @NonNull SecurityStatus security;

    @Tolerate
    public User() {
    }
}
