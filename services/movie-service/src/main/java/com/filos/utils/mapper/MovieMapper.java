package com.filos.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.filos.repository.model.BasicInfo;
import com.filos.repository.model.Genre;
import com.filos.repository.model.Keyword;
import com.filos.repository.model.Movie;
import com.filos.repository.model.ProductionCompany;
import com.filos.repository.model.ProductionCountry;
import com.filos.web.requests.SaveMovieRequest;
import com.filos.web.responses.BasicInformationMovie;
import com.filos.web.responses.MovieDto;

@Mapper
public interface MovieMapper {
    @Mapping(source = "id", target = "imdbId")
    @Mapping(target = "id", ignore = true)
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
    @Mapping(source = "statistic.budget", target = "statistics.budget")
    @Mapping(source = "statistic.releaseDate", target = "statistics.releaseDate")
    @Mapping(source = "statistic.revenue", target = "statistics.income")
    MovieDto mapFromData(com.filos.repository.model.Movie movie);

    @Mapping(source = "tagline", target = "basic.tagline")
    @Mapping(source = "title", target = "basic.title")
    @Mapping(source = "runtime", target = "basic.runtime")
    @Mapping(source = "overview", target = "basic.overview")
    @Mapping(source = "originalTitle", target = "basic.originalTitle")
    @Mapping(source = "homepage", target = "supplementary.homepage")
    @Mapping(source = "originalLanguage", target = "supplementary.originalLanguage")
    @Mapping(source = "popularity", target = "supplementary.popularity")
    @Mapping(source = "budget", target = "statistic.budget")
    @Mapping(source = "revenue", target = "statistic.revenue")
    @Mapping(source = "releaseDate", target = "statistic.releaseDate")
    Movie mapFromData(SaveMovieRequest movieRequest);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "tagline", target = "tagline")
    @Mapping(source = "overview", target = "overview")
    @Mapping(source = "runtime", target = "runtime")
    BasicInformationMovie from(BasicInfo info);

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
