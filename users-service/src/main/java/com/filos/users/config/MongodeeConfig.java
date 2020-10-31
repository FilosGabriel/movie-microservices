package com.filos.users.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mongodee")
@Getter
@EnableConfigurationProperties
@Setter
public class MongodeeConfig {

    /**
     *  mongo url for mongodee
     */
    private String urlMongo;

    /**
     * packages to scan
     */
    private String packageToScan;
}
