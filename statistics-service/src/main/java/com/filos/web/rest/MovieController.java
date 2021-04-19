package com.filos.web.rest;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final ReactiveRedisOperations<String, String> operations;

    @GetMapping("/all")
    public Flux<Object> getAll() {
        return operations.keys("*")
                         .flatMap(operations.opsForValue()::get);
    }
}
