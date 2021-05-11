package com.filos.suggestions.repository.elastic;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import com.filos.suggestions.repository.model.SearchData;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SearchRepository {
    private final ElasticsearchOperations operations;

    public List<SearchData> findSuggestions(String text) {
        WildcardQueryBuilder queryTitle = QueryBuilders.wildcardQuery("title", "*" + text + "*");

        NativeSearchQuery titleSearch = new NativeSearchQueryBuilder()
                .withFilter(queryTitle)
                .withPageable(PageRequest.of(0, 10))
                .build();
        SearchHits<SearchData> suggestions = operations.search(titleSearch, SearchData.class, IndexCoordinates.of("movieindex"));
        return suggestions.getSearchHits().stream()
                          .map(SearchHit::getContent)
                          .collect(Collectors.toList());
    }

}
