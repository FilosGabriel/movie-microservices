package com.filos.gateway.docs;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    private static boolean filterServices(RouteDefinition routeDefinition) {
        return routeDefinition.getId()
                              .matches(".*-service");
    }

    private static String removePrefix(RouteDefinition routeDefinition) {
        return routeDefinition.getId()
                              .replaceAll("-service", "");
    }

    private static GroupedOpenApi convertToGroupOpenApi(String name) {
        return GroupedOpenApi.builder()
                             .pathsToMatch("/" + name + "/**")
                             .setGroup(name)
                             .build();
    }

    @Bean
    public List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {
        return Objects.requireNonNull(locator.getRouteDefinitions()
                                             .collectList()
                                             .block())
                      .stream()
                      .filter(OpenApiConfig::filterServices)
                      .map(OpenApiConfig::removePrefix)
                      .map(OpenApiConfig::convertToGroupOpenApi)
                      .collect(Collectors.toList());
    }
}
