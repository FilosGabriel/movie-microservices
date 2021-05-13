package com.filos.service;

import java.util.Map;

import org.springframework.data.redis.core.ReactiveRedisOperations;

import com.filos.data.fields.Fields;
import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class BasicStatisticService {
    private final ReactiveRedisOperations<Fields.Field, Long> operationsInteger;


    public void increment(Fields.Field field) {
        operationsInteger.opsForValue().increment(field)
                         .log("Value for field " + field + " was increased.");
    }

    public void decrement(Fields.Field field) {
        operationsInteger.opsForValue().decrement(field)
                         .log("Value for field " + field + " was decreased.");
    }

    public void newMovie(Map<String, String> movie) {

    }


}
