package com.filos.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.filos.utils.validation.annotation.ValidRangeRuntime;
import com.filos.web.requests.search.Range;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ValidRangeRuntimeValidator implements ConstraintValidator<ValidRangeRuntime, Range<Long>> {
    private ValidRangeRuntime runtime;

    @Override
    public void initialize(ValidRangeRuntime constraintAnnotation) {
        runtime = constraintAnnotation;
    }

    @Override
    public boolean isValid(Range<Long> value, ConstraintValidatorContext context) {
        return value.getMin() > runtime.min() && value.getMax() < runtime.max();
    }

}