package com.filos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("imageConfiguration")
@Data
@ConfigurationProperties(prefix = "movie-db")
public class ImageConfiguration {
    private String key;
    private String url;
    private String sourcePath;
}
