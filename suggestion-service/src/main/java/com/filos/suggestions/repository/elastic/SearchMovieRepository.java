package com.filos.suggestions.repository.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.filos.suggestions.repository.model.SearchData;

@Repository
public interface SearchMovieRepository extends ElasticsearchRepository<SearchData, String> {

    Page<SearchData> findByTitle(String title, PageRequest pageRequest);
}
