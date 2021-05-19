package com.filos.services.builder;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import com.filos.repository.model.QMovie;
import com.filos.web.requests.search.FilterOption;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;

public class OptionalFilterBuilder {
    private final QMovie qMovie;
    private BooleanBuilder predicate;

    private OptionalFilterBuilder() {
        this.qMovie = QMovie.movie;
        predicate = new BooleanBuilder();
    }

    public static OptionalFilterBuilder builder() {
        return new OptionalFilterBuilder();
    }

    public <T> OptionalFilterBuilder addAllowedFilter(Function<List<T>, BooleanExpression> condition, Map<T, FilterOption> request) {
        List<T> allowed = FilterOption.extractAllowed(request);
        if (!allowed.isEmpty()) {
            predicate.and(condition.apply(allowed));
        }
        return this;
    }

    public <T> OptionalFilterBuilder addDeniedFilter(Function<List<T>, BooleanExpression> condition, Map<T, FilterOption> request) {
        List<T> denied = FilterOption.extractDenied(request);
        if (!denied.isEmpty()) {
            predicate.and(condition.apply(denied));
        }
        return this;
    }

    public OptionalFilterBuilder addTextFilter(StringPath path, String text) {
        if (StringUtils.isNotBlank(text)) {
            predicate.and(path.containsIgnoreCase(text));
        }
        return this;
    }

    public Predicate build() {
        return predicate;
    }
}
