package com.filos;

import com.filos.api.EnableMultiTenantsModule;
import com.filos.api.InboundRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableMultiTenantsModule
@RestController
public class DummyService {

    public static void main(String[] args) {
        SpringApplication.run(DummyService.class, args);
    }

    @GetMapping
    @InboundRequest
    public String getPath() {
        return "sda";
    }
}
