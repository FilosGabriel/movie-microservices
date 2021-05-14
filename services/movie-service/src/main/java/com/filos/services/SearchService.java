package com.filos.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.filos.repository.model.Movie;
import com.filos.repository.mongo.MovieRepository;
import com.filos.services.builder.FilterBuilder;
import com.filos.web.requests.SearchRequest;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MovieRepository movieRepository;

    public void searchMovies(SearchRequest request) {
        Predicate predicate = FilterBuilder.builder()
                                           .create(request)
                                           .build();

        Page<Movie> page = movieRepository.findAll(predicate, request.getPageRequest());
    }

}
