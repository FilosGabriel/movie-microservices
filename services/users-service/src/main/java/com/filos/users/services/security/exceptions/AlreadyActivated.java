package com.filos.users.services.security.exceptions;

public class AlreadyActivated extends RuntimeException {
    public AlreadyActivated(String message) {
        super(message);
    }

    public static AlreadyActivated totp() {
        return new AlreadyActivated("TOTP is already activated.");
    }

    public static AlreadyActivated sms() {
        return new AlreadyActivated("SMS is already activated.");
    }
}
