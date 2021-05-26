package com.filos.gateway.routes;

import static com.filos.gateway.routes.ServiceConstants.LB;
import static com.filos.gateway.routes.ServiceConstants.Service.IMAGE;
import static com.filos.gateway.routes.ServiceConstants.v1Api;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageRoutes {
    @Bean
    public RouteLocator publicImageRoute(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                                  .route(IMAGE, r -> r.path(v1Api.formatted("images/**"))
                                                      .uri(LB.formatted(IMAGE)))
                                  .build();
    }
}
