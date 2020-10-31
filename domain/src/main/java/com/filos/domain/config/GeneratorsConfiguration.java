package com.filos.domain.config;

import com.filos.domain.generators.UsersGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneratorsConfiguration {
    @Bean
    public UsersGenerator loadUserGenerator() {
        return new UsersGenerator();
    }
}
