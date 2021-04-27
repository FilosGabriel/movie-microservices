package com.filos.users.config.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.zxing.qrcode.QRCodeWriter;

@Configuration
public class ServiceBeansConfig {

    @Bean
    public QRCodeWriter initQr() {
        return new QRCodeWriter();
    }

    @Bean
    public ModelMapper initMapper() {
        return new ModelMapper();
    }
}
