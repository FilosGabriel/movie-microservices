package com.filos.data.fields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Fields {
    public static final String SCORE = "score";

    @Getter
    @RequiredArgsConstructor
    public enum Score implements Field {
        AVG("avg_score"),
        NO("no_score"),
        NO_AVG_PER_YEAR("no_avg_score_per_year"),
        AVG_PER_YEAR("avg_score_per_year");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Genre implements Field {
        NO("no_genres"),
        MOST_POPULAR("most_popular_genres"),
        LEAST_POPULAR("least_popular_genres");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Keywords implements Field {
        NO("no_keywords"),
        MOST_POPULAR("most_popular_keywords"),
        LEAST_POPULAR("least_popular_keywords");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Companies implements Field {
        NO("no_companies"),
        MOST_POPULAR("most_popular_companies"),
        LEAST_POPULAR("least_popular_companies");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Countries implements Field {
        NO("no_countries"),
        MOST_POPULAR("most_popular_countries"),
        LEAST_POPULAR("least_popular_countries");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Users implements Field {
        NO("users_no");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Movie implements Field {
        NO("no_movies"),
        NO_YEAR("no_movies_per_year");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Budget implements Field {
        RANGE("budget_range"),
        RANGE_YEAR("budget_range_year");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Other implements Field {
        LANGUAGES("language"),
        RUNTIME("runtime");
        private final String value;
    }

    public interface Field {
        String getValue();

        default String param(Long id) {
            return getValue() + ":" + id;
        }
    }

    public static String getFieldWithValue(Field field, Long id) {
        return field.getValue() + id;
    }
}
