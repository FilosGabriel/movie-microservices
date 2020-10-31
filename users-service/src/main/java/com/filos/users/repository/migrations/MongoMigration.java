package com.filos.users.repository.migrations;

import com.filos.users.config.MongobeeContext;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

public abstract class MongoMigration {
    protected ApplicationContext getApplicationContext(Environment environment) {
        if (environment instanceof MongobeeContext context)
            return context.getApplicationContext();
        throw new IllegalArgumentException();
    }
}
