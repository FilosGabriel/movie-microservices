package com.filos.users.repository.model;

import javax.validation.constraints.Email;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document
public class ContactInformation {
    @Indexed
    @Email(message = "Email is not valid")
    private String email;
    @Indexed
    private String phoneNumber;
}
