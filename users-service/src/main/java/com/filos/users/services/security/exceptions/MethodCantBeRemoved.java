package com.filos.users.services.security.exceptions;

public class MethodCantBeRemoved extends RuntimeException {
    public MethodCantBeRemoved(String message) {
        super(message);
    }

    public static MethodCantBeRemoved sms() {
        return new MethodCantBeRemoved("");
    }
}
