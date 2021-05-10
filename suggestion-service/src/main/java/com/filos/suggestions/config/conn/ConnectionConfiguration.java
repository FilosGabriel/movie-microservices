package com.filos.suggestions.config.conn;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "connections")
public class ConnectionConfiguration {
    public final String elasticsearchConnection = "localhost:9200";
}
