package com.filos.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "movie.security")
@Data
public class SecurityProperties {
    public final String secret = "SecretKeyToGenJWTs";
    public final long expirationTime = 864_000_000; // 10 days
    public final String tokenPrefix = "Bearer ";
    public final String Header = "Authorization";
    public final String url = "/users/sign-up";
}
