package com.filos.users.web.exceptions;

public class MissingRequiredInformation extends RuntimeException{
    public MissingRequiredInformation(String message) {
        super(message);
    }
}
