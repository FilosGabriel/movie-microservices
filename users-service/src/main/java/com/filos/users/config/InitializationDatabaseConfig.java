package com.filos.users.config;

import com.github.mongobee.Mongobee;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
@RequiredArgsConstructor
public class InitializationDatabaseConfig {
    private final MongodeeConfig mongodeeConfig;

//    @Bean
    public Mongobee initDb(final Environment environment, ApplicationContext context) {
        Mongobee migrationRunner = new Mongobee(mongodeeConfig.getUrlMongo());
        migrationRunner.setChangeLogsScanPackage(mongodeeConfig.getPackageToScan());
        migrationRunner.setSpringEnvironment(new MongobeeContext(environment, context));
        return migrationRunner;
    }
}
