package com.filos.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DummyHandler {

    public Mono<ServerResponse> helloWord(ServerRequest request) {
        return ServerResponse.accepted()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello" + request.pathVariable("name")));
    }
}
