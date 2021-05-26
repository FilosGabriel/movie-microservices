package com.filos.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.filos.repository.model.Movie;
import com.filos.repository.model.QMovie;
import com.filos.repository.mongo.MovieRepository;
import com.filos.services.builder.OptionalFilterBuilder;
import com.filos.utils.converters.PageConverter;
import com.filos.web.requests.SearchRequest;
import com.filos.web.responses.PagedResponse;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MovieRepository movieRepository;
    private final PageConverter<Movie> converter;

    public PagedResponse<Object> searchMovies(SearchRequest request, Pageable pageable) {
        QMovie qMovie = QMovie.movie;
        Predicate predicate = OptionalFilterBuilder.builder()
                                                   .addTextFilter(qMovie.basic.title, request.getText())
                                                   .addAllowedFilter(qMovie.genres.any().id::in, request.getGenres())
                                                   .addAllowedFilter(qMovie.keywords.any().id::in, request.getKeywords())
                                                   //        addAllowedFilter(qMovie.countries.any().name::in, request.getKeywords());
                                                   .addAllowedFilter(qMovie.companies.any().id::in, request.getCompanies())
                                                   .addDeniedFilter(qMovie.genres.any().id::notIn, request.getGenres())
                                                   .addDeniedFilter(qMovie.keywords.any().id::notIn, request.getKeywords())
                                                   //        addDeniedFilter(qMovie.keywords.any().id::notIn, request.getKeywords());
                                                   .addDeniedFilter(qMovie.companies.any().id::notIn, request.getCompanies())
                                                   .build();

        Page<Movie> page = movieRepository.findAll(predicate, pageable);
        return converter.convertToPage(request, page);
    }

}
