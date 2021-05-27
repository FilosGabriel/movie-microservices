package com.filos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.filos.tenants") // todo fix this
public class MultiTenantsConfig {
}
