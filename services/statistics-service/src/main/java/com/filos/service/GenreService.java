package com.filos.service;

import java.util.Map;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final ReactiveRedisOperations<String, Map<String, Long>> operations;


    public void newGenre(String genreName){
//        operations.opsForValue().get()
    }
}
