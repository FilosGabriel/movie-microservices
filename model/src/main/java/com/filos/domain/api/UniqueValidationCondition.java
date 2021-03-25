package com.filos.domain.api;

@FunctionalInterface
public interface UniqueValidationCondition {
    boolean validateUserIfUnique(String email, String username);
}
