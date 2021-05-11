package com.filos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.filos.domain.constraints.UniqueUser;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@UniqueUser
public class UserDto {

    @Length(min = 5,max = 30, message = "Username need to have at least 5 characters")
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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate dateOfBirth;

    @JsonIgnore
    private String otp;
}
