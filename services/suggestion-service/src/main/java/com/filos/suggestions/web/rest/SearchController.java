package com.filos.suggestions.web.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filos.suggestions.services.SuggestionService;
import com.filos.suggestions.web.responses.BasicSearchResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/search-service", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {

    private final SuggestionService suggestionService;

    @GetMapping("/suggestion")
    public List<BasicSearchResponse> searchSuggestion(@RequestParam final String text) {
        return suggestionService.searchSuggestionFor(text);
    }

}
