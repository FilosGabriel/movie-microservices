package com.filos.domain.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.filos.domain.constraints.ValidUserPassword;
import com.filos.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import me.gosimple.nbvcxz.Nbvcxz;
import me.gosimple.nbvcxz.scoring.Result;

@RequiredArgsConstructor
public class PasswordCheckerValidator implements ConstraintValidator<ValidUserPassword, UserDto> {
    private final Nbvcxz validator;

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        Result estimation = validator.estimate(userDto.getPassword());
        if (estimation.isMinimumEntropyMet()) {
            return true;
        }
        String warning = estimation.getFeedback().getWarning();
        if (containsNotAllowed(userDto)) {
            warning += "\n Password shouldn't contains input fields.";
        }
        String suggestions = String.join("", estimation.getFeedback().getSuggestion());
        constraintValidatorContext.buildConstraintViolationWithTemplate(warning).addConstraintViolation();
        return false;
    }

    private boolean containsNotAllowed(UserDto userDto) {
        String password = userDto.getPassword().toLowerCase();
        return password.contains(userDto.getEmail().toLowerCase()) ||
                password.contains(userDto.getFirstName().toLowerCase()) ||
                password.contains(userDto.getLastName().toLowerCase()) ||
                password.contains(userDto.getUsername().toLowerCase());

    }
}
