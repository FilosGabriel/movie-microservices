package com.filos.domain.validators;

import com.filos.domain.api.UniqueValidationCondition;
import com.filos.domain.constraints.UniqueUser;
import com.filos.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueUserValidator implements ConstraintValidator<UniqueUser, UserDto> {
    private final UniqueValidationCondition validation;

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        if (!validation.validateUserIfUnique(userDto.getEmail(), userDto.getUsername())) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("{com.filos.uniqueUser}").addConstraintViolation();
            return false;
        }
        return true;
    }
}
