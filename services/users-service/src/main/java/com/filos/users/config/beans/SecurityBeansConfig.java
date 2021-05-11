package com.filos.users.config.beans;

import java.util.Locale;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.filos.domain.api.UniqueValidationCondition;
import com.filos.users.config.constants.Components;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.utils.generators.SecretGenerator;
import me.gosimple.nbvcxz.Nbvcxz;
import me.gosimple.nbvcxz.resources.ConfigurationBuilder;

@Configuration
public class SecurityBeansConfig {

    @Bean(name = Components.Encryption.SHA)
    public DigestUtils createSha() {
        return new DigestUtils(MessageDigestAlgorithms.SHA3_256);
    }

    @Bean
    public UniqueValidationCondition createValidator(UserRepositoryMongo repositoryMongo) {
        return (email, username) -> repositoryMongo.findByBasicInfo_UsernameOrContactInfo_Email(username, email).isEmpty();
    }

    @Bean(name = Components.Validators.PASSWORD)
    @RequestScope
    public Nbvcxz initPasswordValidator() {
        return new Nbvcxz(new ConfigurationBuilder()
                                  .setLocale(Locale.ENGLISH)
                                  .createConfiguration());
    }

    @Bean
    public SecretGenerator initSecretGenerator() {
        return new SecretGenerator();
    }
}
