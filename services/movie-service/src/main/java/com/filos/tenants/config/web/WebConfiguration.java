package com.filos.tenants.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.filos.utils.converters.FilterOptionConverter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        log.info("Registering converter from String to Map<Long,FilterOption>. ");
        registry.addConverter(new FilterOptionConverter());
    }

}
