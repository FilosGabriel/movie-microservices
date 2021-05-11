package com.filos.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(GeneratorsConfiguration.class)
@Configuration
public @interface EnableGenerators {
}
