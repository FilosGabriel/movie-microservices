module tentants {
    exports com.filos.api;
    exports com.filos.api.data;
    requires lombok;
    requires spring.context;
    requires spring.web;
    requires org.aspectj.weaver;
    requires org.apache.tomcat.embed.core;
}