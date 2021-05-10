package com.filos.suggestions.repository.load;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import com.filos.data.Movie;
import com.filos.reader.MovieReader;
import com.filos.suggestions.repository.model.SearchData;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoadData {
    private final MovieReader data;
    private final ElasticsearchOperations operations;

    @PostConstruct
    public void init() {
        List<Movie> movies = data.readCsv();
        operations.indexOps(SearchData.class).refresh();
        List<SearchData> searchData = movies.stream().map(this::mapper)
                                            .collect(Collectors.toList());
        operations.save(searchData);

    }

    private SearchData mapper(Movie movie) {
        SearchData searchData = new SearchData();
        searchData.setTitle(movie.title);
        searchData.setExternalId(movie.id);
        return searchData;
    }
}
