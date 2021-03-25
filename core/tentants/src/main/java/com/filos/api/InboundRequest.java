package com.filos.api;

import lombok.Data;

public @interface InboundRequest{
    String[] operations() default "";
}
