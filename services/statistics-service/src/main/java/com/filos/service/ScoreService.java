package com.filos.service;

import java.util.List;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;

import com.filos.data.fields.Fields;
import com.filos.utils.collectors.statistic.Score;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ReactiveRedisOperations<Fields.Field, Double> operationsDouble;
    private final ReactiveRedisOperations<Fields.Field, Long> operationsInteger;
    private final ReactiveRedisOperations<String, Double> scoreOperations;

    public void newScore(double newScore, long year) {
        scoreOperations.opsForHash()
                       .multiGet(Fields.SCORE, List.of(Fields.Score.NO, Fields.Score.AVG,
                                                       Fields.Score.NO_AVG_PER_YEAR.param(year),
                                                       Fields.Score.AVG_PER_YEAR.param(year)
                       )).subscribe(values -> updateAverageScoreWithNewValue(values, newScore));
        operationsDouble.opsForValue().get(Fields.Score.NO)
                        .zipWith(operationsDouble.opsForValue().get(Fields.Score.AVG))
                        .subscribe(tuple -> updateAverageScoreWithNewValue(tuple.getT1(), newScore, tuple.getT2()));
        operationsInteger.opsForValue().increment(Fields.Score.NO);
    }

    public void deleteScore(double deletedScore) {
        operationsDouble.opsForValue().get(Fields.Score.AVG)
                        .zipWith(operationsDouble.opsForValue().get(Fields.Movie.NO))
                        .subscribe(tuple -> updateAverageScoreWithDeletedScore(tuple.getT1(), deletedScore, tuple.getT2()));
        operationsInteger.opsForValue().decrement(Fields.Score.AVG);
    }

    private void updateAverageScoreWithNewValue(double score, double valueScore, double noScore) {
        double newScore = Score.calcScoreIncreased(score, valueScore, noScore);
        operationsDouble.opsForValue().set(Fields.Score.AVG, newScore);
    }

    private void updateAverageScoreWithNewValue(List<Object> values, double valueScore) {
        double newScore = Score.calcScoreIncreased((double) values.get(1), valueScore, (double) values.get(0));
        operationsDouble.opsForValue().set(Fields.Score.AVG, newScore);
    }

    private void updateAverageScoreWithDeletedScore(double score, double valueScore, double noScore) {
        double newScore = Score.calcScoreDeleted(score, valueScore, noScore);
        operationsDouble.opsForValue().set(Fields.Score.AVG, newScore);
    }
}
