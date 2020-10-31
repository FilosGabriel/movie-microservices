package com.filos.users.config;

import com.google.zxing.qrcode.QRCodeWriter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public QRCodeWriter get() {
        return new QRCodeWriter();
    }

    @Bean
    public ModelMapper init() {
        return new ModelMapper();
    }

}
