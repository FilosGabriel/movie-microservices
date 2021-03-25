package com.filos.interceptors;

import com.filos.response.ResponseSimulatedResolver;
import com.filos.response.SimulatedResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class RequestSimulatorInterceptor implements ClientHttpRequestInterceptor {
    private ResponseSimulatedResolver resolver;

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        String requestPath = httpRequest.getURI().getPath();
        Optional<SimulatedResponse> response = resolver.getResponseFor(requestPath);
        return response.orElseThrow(RuntimeException::new);
    }
}
