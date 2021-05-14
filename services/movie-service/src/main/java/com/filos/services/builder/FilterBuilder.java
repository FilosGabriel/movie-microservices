package com.filos.services.builder;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import com.filos.repository.model.QMovie;
import com.filos.web.requests.SearchRequest;
import com.filos.web.requests.search.FilterOption;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;

public class FilterBuilder implements IntermediaryBuilder, FinalBuilder {
    private final QMovie qMovie;
    private final BooleanBuilder predicate;

    private FilterBuilder() {
        this.qMovie = QMovie.movie;
        predicate = new BooleanBuilder(qMovie.isNotNull());
    }

    public FinalBuilder create(SearchRequest request) {
        //        qMovie.countries.any().name.eqAny()
        addTextFilter(qMovie.basic.title, request.getText());
        addAllowedFilter(qMovie.genres.any().id::in, request.getGenres());
        addAllowedFilter(qMovie.keywords.any().id::in, request.getKeywords());
        //        addAllowedFilter(qMovie.countries.any().name::in, request.getKeywords());
        addAllowedFilter(qMovie.companies.any().id::in, request.getCompanies());
        addDeniedFilter(qMovie.genres.any().id::notIn, request.getGenres());
        addDeniedFilter(qMovie.keywords.any().id::notIn, request.getKeywords());
        //        addDeniedFilter(qMovie.keywords.any().id::notIn, request.getKeywords());
        addDeniedFilter(qMovie.companies.any().id::notIn, request.getCompanies());
        return this;
    }

    public static IntermediaryBuilder builder() {
        return new FilterBuilder();
    }

    private <T> void addAllowedFilter(Function<List<T>, BooleanExpression> condition, Map<T, FilterOption> request) {
        List<T> allowed = FilterOption.extractAllowed(request);
        if (!allowed.isEmpty()) {
            predicate.and(condition.apply(allowed));
        }
    }

    private <T> void addDeniedFilter(Function<List<T>, BooleanExpression> condition, Map<T, FilterOption> request) {
        List<T> denied = FilterOption.extractDenied(request);
        if (!denied.isEmpty()) {
            predicate.and(condition.apply(denied));
        }
    }

    private void addTextFilter(StringPath path, String text) {
        if (StringUtils.isNotBlank(text)) {
            predicate.and(path.containsIgnoreCase(text));
        }
    }

    @Override
    public Predicate build() {
        return predicate;
    }
}
