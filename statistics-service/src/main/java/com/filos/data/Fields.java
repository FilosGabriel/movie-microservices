package com.filos.data;

import lombok.Getter;

@Getter
public enum Fields{
    NO_OF_MOVIE("movie_no"),
    AVERAGE_SCORE("avg_score"),
    NO_SCORE("avg_score"),
    ;
    private final String value;

    Fields(String value) {
        this.value = value;
    }
}
