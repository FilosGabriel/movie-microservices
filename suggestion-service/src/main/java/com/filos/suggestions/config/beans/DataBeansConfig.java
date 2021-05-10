package com.filos.suggestions.config.beans;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.filos.reader.MovieReader;
import com.filos.suggestions.utils.mapper.SearchMapper;

@Configuration
public class DataBeansConfig {
    @Bean
    public MovieReader initReader(){
        return new MovieReader("C:\\Users\\gfilos\\Downloads\\movie-microservices\\data\\tmdb_5000_movies.csv");
    }

    @Bean
    public SearchMapper initMapper() {
        return Mappers.getMapper(SearchMapper.class);
    }
}
