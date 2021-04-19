package com.filos.users.config;

import java.util.Locale;

import com.filos.domain.api.UniqueValidationCondition;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.services.api.ExternalNotifier;
import com.google.zxing.qrcode.QRCodeWriter;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.annotation.RequestScope;

import me.gosimple.nbvcxz.Nbvcxz;
import me.gosimple.nbvcxz.resources.ConfigurationBuilder;

@Configuration
public class ServiceConfig {

    @Bean
    public QRCodeWriter initQr() {
        return new QRCodeWriter();
    }

    @Bean
    public ModelMapper initMapper() {
        return new ModelMapper();
    }

    @Bean(name = "sha")
    public DigestUtils createSha() {
        return new DigestUtils("SHA3-256");
    }

    @Bean
    public UniqueValidationCondition createValidator(UserRepositoryMongo repositoryMongo) {
        return (email, username) -> repositoryMongo.findByUsernameOrEmail(username, email).isEmpty();
    }

    @Bean
    @Profile(AppProfiles.DEFAULT)
    public ExternalNotifier create() {
        return new ExternalNotifier() {
            @Override
            public void deleteUser(String id) {
                System.out.println("delete");
            }

            @Override
            public void createUser(String id) {
                System.out.println("create");
            }
        };
    }

    @Bean(name = "passwordValidator")
    @RequestScope
    public Nbvcxz initPasswordValidator() {
        return new Nbvcxz(new ConfigurationBuilder()
                                  .setLocale(Locale.ENGLISH)
                                  .createConfiguration());
    }
}
