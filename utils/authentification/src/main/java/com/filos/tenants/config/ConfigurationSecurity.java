package com.filos.tenants.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigurationSecurity {

    @Bean
    public BCryptPasswordEncoder instantiatePasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
