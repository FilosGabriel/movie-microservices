module domain {
    exports com.filos.domain.dto;
    requires static lombok;
    requires java.validation;
    requires com.fasterxml.jackson.annotation;
    requires javafaker;
    requires com.google.common;
    exports com.filos.domain.config;
    requires spring.context;

}