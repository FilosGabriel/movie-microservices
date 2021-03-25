package com.filos.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;

public class SimulatedResponse implements ClientHttpResponse {
    @Override
    public HttpStatus getStatusCode() throws IOException {
        return null;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return 0;
    }

    @Override
    public String getStatusText() throws IOException {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getBody() throws IOException {
        return null;
    }

    @Override
    public HttpHeaders getHeaders() {
        return null;
    }
}
