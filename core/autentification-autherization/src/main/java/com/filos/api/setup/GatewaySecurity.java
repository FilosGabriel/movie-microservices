package com.filos.api.setup;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Configuration
public @interface GatewaySecurity{
}