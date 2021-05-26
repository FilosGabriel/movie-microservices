package com.filos.tenants.config.beans;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.filos.reader.MovieReader;
import com.filos.utils.mapper.MovieMapper;

@Configuration
public class LoaderBeansConfig {

    @Bean
    public MovieReader initReader(AppConfig config) {
        return new MovieReader(config.getFile());
    }

    @Bean
    public MovieMapper initMapper() {
        return Mappers.getMapper(MovieMapper.class);
    }
}
