package com.filos.gateway.routes;

import static com.filos.gateway.routes.ServiceConstants.LB;
import static com.filos.gateway.routes.ServiceConstants.Service.MOVIE;
import static com.filos.gateway.routes.ServiceConstants.v1Api;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import com.filos.gateway.filters.AuthenticationFilter;

@Configuration
public class MovieRoutes {

    @Bean
    public RouteLocator unprotectedMovieRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                      .route(MOVIE + "public", r -> r.path(v1Api.formatted("movies"))
                                                     .and()
                                                     .method(HttpMethod.GET)
                                                     .uri(LB.formatted(MOVIE)))
                      .build();
    }

    @Bean
    public RouteLocator protectedMovieRoute(RouteLocatorBuilder builder, AuthenticationFilter authenticationFilter) {
        return builder.routes()
                      .route(MOVIE + "protected", r -> r.path(v1Api.formatted("movies"))
                                                        .and()
                                                        .method(HttpMethod.POST)
                                                        .filters(f -> f.filters(authenticationFilter))
                                                        .uri(LB.formatted(MOVIE)))
                      .build();
    }
}
