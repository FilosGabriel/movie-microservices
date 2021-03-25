package com.filos.interceptors;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "simulators")
@Data
public class SimulatorsConfiguration {

    /**
     * Enable simulated requests
     */
    private final boolean enabled = false;

    /**
     * Paths to json mock requests, each path should split by ","
     */
    private List<String> paths = new ArrayList<>();
}
