package com.filos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gateway {

    public static void main(String[] args) {
        SpringApplication.run(Gateway.class);
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
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("movie_route", Gateway::movieRoute)
//                .route("user_route", Gateway::userRoute)
//                .build();
//    }
}
