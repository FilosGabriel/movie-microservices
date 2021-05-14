package com.filos.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.filos.repository.model.Movie;
import com.filos.web.responses.MovieDto;

@Mapper
public interface MovieMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "originalTitle", target = "basic.originalTitle")
    @Mapping(source = "overview", target = "basic.overview")
    @Mapping(source = "runtime", target = "basic.runtime")
    @Mapping(source = "tagline", target = "basic.tagline")
    @Mapping(source = "title", target = "basic.title")
    @Mapping(source = "homepage", target = "supplementary.homepage")
    @Mapping(source = "originalLanguage", target = "supplementary.originalLanguage")
    @Mapping(source = "popularity", target = "supplementary.popularity")
    @Mapping(source = "budget", target = "statistic.budget")
    @Mapping(source = "releaseDate", target = "statistic.releaseDate")
    @Mapping(source = "revenue", target = "statistic.revenue")
    Movie mapFromData(com.filos.data.Movie movie);

    MovieDto mapFromData(com.filos.repository.model.Movie movie);
    Movie mapFromData(com.filos.web.responses.MovieDto movie);
}
