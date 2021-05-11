package com.filos.suggestions.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.filos.suggestions.repository.elastic.SearchRepository;
import com.filos.suggestions.utils.mapper.SearchMapper;
import com.filos.suggestions.web.responses.BasicSearchResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SuggestionService {
    private final SearchMapper searchMapper;
    private final SearchRepository searchRepository;

    public List<BasicSearchResponse> searchSuggestionFor(String request) {
        return searchRepository.findSuggestions(request).stream()
                               .map(searchMapper::mapToResponse)
                               .collect(Collectors.toList());
    }

}
