package com.filos.gateway.routes;

import static com.filos.gateway.routes.ServiceConstants.LB;
import static com.filos.gateway.routes.ServiceConstants.Service.STATISTICS;
import static com.filos.gateway.routes.ServiceConstants.v1Api;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StatisticsRoute {
    @Bean
    public RouteLocator publicStatisticsRoute(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                                  .route(STATISTICS, r -> r.path(v1Api.formatted("/statistics/**"))
                                                           .uri(LB.formatted(STATISTICS)))
                                  .build();
    }
}
