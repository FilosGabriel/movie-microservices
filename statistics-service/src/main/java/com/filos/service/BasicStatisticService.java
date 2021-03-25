package com.filos.service;

import com.filos.data.Fields;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BasicStatisticService{
    private final ReactiveValueOperations<Fields, Integer> operationsInteger;
    private final ReactiveValueOperations<Fields, Double> operationsDouble;

    public void increment(Fields field) {
        operationsInteger.increment(field)
                .log("Value increased for {}");
    }

    public void decrement(Fields field) {
        operationsInteger.decrement(field);
    }

    public void newMovie(Map<String, String> movie) {

    }

    public void newScore(double newScore) {
        operationsDouble.get(Fields.NO_OF_MOVIE)
                .subscribe(actual -> operationsDouble.set(Fields.AVERAGE_SCORE, actual + newScore));
        operationsInteger.increment(Fields.NO_SCORE);
    }

    public void deleteScore(double oldScore) {
        operationsDouble.get(Fields.NO_OF_MOVIE)
                .subscribe(actual -> operationsDouble.set(Fields.AVERAGE_SCORE, actual - oldScore));
        operationsInteger.decrement(Fields.NO_SCORE);
    }

}
