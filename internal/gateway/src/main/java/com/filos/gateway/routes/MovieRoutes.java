package com.filos.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class MovieRoutes {

    @Bean
    public RouteLocator movieServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                      .route("movie-service", r -> r.path("/v1/api/movies")
                                                    .and()
                                                    .method(HttpMethod.GET)
                                                    .uri("lb://MOVIE-SERVICE"))
                      .build();
    }
}
