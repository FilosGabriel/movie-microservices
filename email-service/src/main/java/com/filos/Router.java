package com.filos;

import com.filos.handlers.DummyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> route(DummyHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/hello/{name}")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::helloWord);
    }
}
