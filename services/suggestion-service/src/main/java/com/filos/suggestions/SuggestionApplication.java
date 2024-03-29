package com.filos.suggestions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class SuggestionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuggestionApplication.class, args);
    }
}
