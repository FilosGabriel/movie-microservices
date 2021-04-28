package com.filos.users.services.validators;

import java.util.function.Supplier;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validations {
    public static <T extends RuntimeException> void checkOrThrow(boolean value, Supplier<T> supplier) {
        if (value) {
            supplier.get();
        }
    }
}
