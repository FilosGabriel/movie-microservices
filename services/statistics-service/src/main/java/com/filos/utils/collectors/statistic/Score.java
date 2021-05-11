package com.filos.utils.collectors.statistic;

public class Score {

    public static double calcScoreIncreased(double score, double valueScore, double noScore) {
        return ((score * noScore) + valueScore) / (noScore + 1);
    }

    public static double calcScoreDeleted(double score, double valueScore, double noScore) {
        return ((score * noScore) - valueScore) / (noScore - 1);
    }
}
