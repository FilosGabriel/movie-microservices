package com.filos.response;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ResponseSimulatedResolver {
    private final Map<String, SimulatedResponse> responses;

    public ResponseSimulatedResolver() {
        responses = new HashMap<>();

    }

    public Optional<SimulatedResponse> getResponseFor(String requestPath) {
        return Optional.ofNullable(responses.get(requestPath));
    }
}
