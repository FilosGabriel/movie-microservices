package com.filos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "movieDb")
public class ImageConfiguration {
    private String key;
    private String sourcePath;
}
