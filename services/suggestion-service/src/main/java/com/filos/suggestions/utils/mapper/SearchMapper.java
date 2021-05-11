package com.filos.suggestions.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.filos.suggestions.repository.model.SearchData;
import com.filos.suggestions.web.responses.BasicSearchResponse;
import com.filos.suggestions.web.responses.BasicSearchResponseWithScore;

@Mapper
public interface SearchMapper {
    @Mapping(target = "id", source = "externalId")
    @Mapping(target = "title", source = "title")
    BasicSearchResponse mapToResponse(SearchData data);

    @Mapping(target = "id", source = "externalId")
    @Mapping(target = "title", source = "title")
    BasicSearchResponseWithScore mapToResponseWithScore(SearchData data);
}
