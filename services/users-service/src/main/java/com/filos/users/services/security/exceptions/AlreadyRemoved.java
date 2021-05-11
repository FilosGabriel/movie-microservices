package com.filos.users.services.security.exceptions;

public class AlreadyRemoved extends RuntimeException {
    public AlreadyRemoved(String message) {
        super(message);
    }

    public static AlreadyRemoved sms() {
        return new AlreadyRemoved("");
    }

    public static AlreadyRemoved totp() {
        return new AlreadyRemoved("");
    }
}
