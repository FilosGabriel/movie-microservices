package filos.api;

public @interface InboundRequest{
    String[] operations() default "";
}
