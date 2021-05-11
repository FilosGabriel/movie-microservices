package com.filos.users.services.security.exceptions;

public class InvalidLoginRequest extends RuntimeException {
    public InvalidLoginRequest(String message) {
        super(message);
    }

    public static InvalidLoginRequest password() {
        return new InvalidLoginRequest("Password didn't match");
    }

    public static InvalidLoginRequest method() {
        return new InvalidLoginRequest("Method not supported");
    }
}
