package com.filos.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class UserDto {

    @Min(value = 5, message = "Username need to have at least 5 characters")
    @Max(value = 30, message = "Username need to have at most 30 characters")
    @NotBlank(message = "Username need to not be blank")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Email
    private String email;

    @NotBlank(message = "You need to have a fist name")
    private String firstName;

    @NotBlank(message = "You need to have a last name")
    private String lastName;

    private Instant dateOfBirth;

    @JsonIgnore
    private String otp;
}
