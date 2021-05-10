package com.filos.suggestions.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.filos.suggestions.repository.elastic.SearchMovieRepository;
import com.filos.suggestions.repository.model.SearchData;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SuggestionService {
    private final SearchMovieRepository repository;

    public List<SearchData> searchSuggestionFor(String request) {
        Page<SearchData> result = repository.findByTitle(request, PageRequest.of(0, 10));
        return result.toList().;
    }

}
