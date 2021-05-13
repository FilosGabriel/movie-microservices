package com.filos.data;

import java.util.List;

import com.filos.converters.JsonConverterCompanies;
import com.filos.converters.JsonConverterCountry;
import com.filos.converters.JsonConverterGenre;
import com.filos.converters.JsonConverterKeywords;
import com.univocity.parsers.annotations.Convert;
import com.univocity.parsers.annotations.Parsed;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Movie {
    @Parsed
    public long budget;
    @Parsed
    @Convert(conversionClass = JsonConverterGenre.class)
    public List<Genre> genres;
    @Parsed
    public String homepage;
    @Parsed
    public long id;
    @Parsed
    @Convert(conversionClass = JsonConverterKeywords.class)
    public List<Keyword> keywords;
    @Parsed(field = "original_language")
    public String originalLanguage;
    @Parsed(field = "original_title")
    public String originalTitle;
    @Parsed
    public String overview;
    @Parsed
    public float popularity;
    @Parsed(field = "production_countries")
    @Convert(conversionClass = JsonConverterCountry.class)
    public List<ProductionCountry> countries;
    @Parsed(field = "production_companies")
    @Convert(conversionClass = JsonConverterCompanies.class)
    public List<ProductionCompany> companies;
    @Parsed(field = "release_date")
    public String releaseDate;
    @Parsed
    public double revenue;
    @Parsed
    public double runtime;
    @Parsed
    public String tagline;
    @Parsed
    public String title;

}
