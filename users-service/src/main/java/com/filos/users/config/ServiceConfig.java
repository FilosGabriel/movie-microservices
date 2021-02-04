package com.filos.users.config;

import com.filos.users.utils.generators.UsersGenerator;
import com.google.zxing.qrcode.QRCodeWriter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootConfiguration
public class ServiceConfig implements ApplicationContextInitializer<GenericApplicationContext> {
    private final static BeanDefinitionCustomizer SINGLETON = beanDefinition -> beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);

    public void initServices(GenericApplicationContext context) {
        context.registerBean("qrCodeWriter", QRCodeWriter.class, QRCodeWriter::new, SINGLETON);
        context.registerBean(ModelMapper.class, SINGLETON);
        context.registerBean(UsersGenerator.class, SINGLETON);
    }


    @Override
    public void initialize(GenericApplicationContext context) {
        initServices(context);
    }
}
