package com.filos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class Gateway {

    public static void main(String[] args) {
        SpringApplication.run(Gateway.class);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("discovery", Gateway::discoveryRoute)
                .route("google", Gateway::testService)
                .build();
    }

    private static Buildable<Route> discoveryRoute(PredicateSpec predicateSpec) {
        return predicateSpec.path("/eureka/**")
                .and().method(HttpMethod.GET)
                .filters(rw -> rw.rewritePath("/eureka[^/]", "/"))
                .uri("http://localhost:8761");
    }

    private static Buildable<Route> testService(PredicateSpec predicateSpec) {
        return predicateSpec.path("/google")
                .and().method(HttpMethod.GET)
                .uri("www.google.com");
    }
//    private static Buildable<Route> userRoute(PredicateSpec r) {
//        return r.path("/product/**").and().method(HttpMethod.GET)
//                .filters(Gateway::addHeaders)
//                .uri("lb:://users");
//    }
//
//    private static Buildable<Route> movieRoute(PredicateSpec r) {
//        return r.path("/movies")
//                .and().method(HttpMethod.GET, HttpMethod.POST, HttpMethod.HEAD, HttpMethod.PUT, HttpMethod.DELETE)
//                .filters(Gateway::addHeaders)
//                .uri("lb://movies");
//    }
//
//    private static UriSpec addHeaders(GatewayFilterSpec f) {
//        return f.addRequestHeader("Cache-Control", "max-age=300");
//    }
//

}
