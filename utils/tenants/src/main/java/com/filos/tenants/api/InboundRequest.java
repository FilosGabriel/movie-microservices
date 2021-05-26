package com.filos.tenants.api;

public @interface InboundRequest{
    String[] operations() default "";
}
