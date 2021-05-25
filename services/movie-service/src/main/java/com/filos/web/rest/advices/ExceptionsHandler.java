package com.filos.web.rest.advices;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.filos.web.exceptions.MovieNotFound;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(MovieNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleException(final MovieNotFound ex) {
        return Map.of("message", "Movie not found");
    }
}

