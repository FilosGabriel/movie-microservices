package com.filos.users.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.filos.users.config.AppProfiles;
import com.filos.users.services.api.ExternalNotifier;
import lombok.NonNull;

@Configuration
public class NotifierBeansConfig {

    @Bean
    @Profile(AppProfiles.DEFAULT)
    public ExternalNotifier createPrintNotifierUser() {
        return new ExternalNotifier() {
            @Override
            public void deleteUser(@NonNull String id) {
                System.out.println("delete");
            }

            @Override
            public void createUser(@NonNull String id) {
                System.out.println("create");
            }
        };
    }
}
