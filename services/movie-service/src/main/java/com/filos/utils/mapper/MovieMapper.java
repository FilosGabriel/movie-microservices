package com.filos.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.filos.repository.model.Genre;
import com.filos.repository.model.Keyword;
import com.filos.repository.model.Movie;
import com.filos.repository.model.ProductionCompany;
import com.filos.repository.model.ProductionCountry;
import com.filos.web.requests.SaveMovieRequest;
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

    //    to be done
    @Mapping(source = "countries", target = "details.countries")
    @Mapping(source = "genres", target = "details.genres")
    @Mapping(source = "companies", target = "details.companies")
    @Mapping(source = "keywords", target = "details.keywords")
    @Mapping(source = "supplementary.popularity", target = "basic.popularity")
    @Mapping(source = "supplementary.originalLanguage", target = "basic.originalLanguage")
    @Mapping(source = "supplementary.homepage", target = "basic.homepage")
    MovieDto mapFromData(com.filos.repository.model.Movie movie);

    @Mapping(source = "homepage", target = "supplementary.homepage")
    @Mapping(source = "originalLanguage", target = "supplementary.originalLanguage")
    @Mapping(source = "popularity", target = "supplementary.popularity")
    @Mapping(source = "originalTitle", target = "basic.originalTitle")
    @Mapping(source = "tagline", target = "basic.tagline")
    @Mapping(source = "overview", target = "basic.overview")
    @Mapping(source = "runtime", target = "basic.runtime")
    @Mapping(source = "title", target = "basic.title")
    Movie mapFromData(SaveMovieRequest movieRequest);

    default String from(ProductionCountry country) {
        return country == null ? null : country.name;
    }

    default String from(Keyword country) {
        return country == null ? null : country.name;
    }

    default String from(Genre country) {
        return country == null ? null : country.name;
    }

    default String from(ProductionCompany country) {
        return country == null ? null : country.name;
    }

}
