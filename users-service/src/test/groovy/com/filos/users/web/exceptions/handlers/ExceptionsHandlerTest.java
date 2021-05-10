package com.filos.users.web.exceptions.handlers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.Test;

import com.filos.users.web.exceptions.UserNotFound;

class ExceptionsHandlerTest {
    @Test
    public void test() {
        // Given
        ExceptionsHandler exceptionsHandler = new ExceptionsHandler();
        // When
        Map<String, Object> response = exceptionsHandler.treatNotFound(new UserNotFound());
        // Then
        assertThat(response).contains(MapEntry.entry("message", "User not found."));

    }
}