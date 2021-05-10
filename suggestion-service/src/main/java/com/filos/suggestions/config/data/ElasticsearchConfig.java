package com.filos.suggestions.config.data;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import com.filos.suggestions.config.conn.ConnectionConfiguration;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    private final ConnectionConfiguration config;

    @Override
    @Bean
    public @NonNull RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(config.elasticsearchConnection).build();
        return RestClients.create(clientConfiguration).rest();
    }

}
