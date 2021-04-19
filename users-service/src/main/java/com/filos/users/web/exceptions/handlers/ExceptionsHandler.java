package com.filos.users.web.exceptions.handlers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.filos.users.web.exceptions.UserNotFound;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> treatNotFound(UserNotFound userNotFound) {
        return Map.of("message", "User not found");
    }
}
