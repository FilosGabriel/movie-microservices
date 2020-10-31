package com.filos.users.config;

import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.lang.Nullable;

public class MongobeeContext implements Environment {
    private Environment environment;
    private ApplicationContext applicationContext;

    public MongobeeContext(Environment environment, ApplicationContext applicationContext) {
        this.environment = environment;
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public String[] getActiveProfiles() {
        return environment.getActiveProfiles();
    }

    @Override
    public String[] getDefaultProfiles() {
        return environment.getDefaultProfiles();
    }

    @Override
    public boolean acceptsProfiles(String... strings) {
        return environment.acceptsProfiles(strings);
    }


    @Override
    public boolean acceptsProfiles(Profiles profiles) {
        return environment.acceptsProfiles(profiles);
    }

    @Override
    public boolean containsProperty(String key) {
        return environment.containsProperty(key);
    }

    @Override
    @Nullable
    public String getProperty(String key) {
        return environment.getProperty(key);
    }

    @Override
    public String getProperty(String key, String defaultValue) {
        return environment.getProperty(key, defaultValue);
    }

    @Override
    @Nullable
    public <T> T getProperty(String key, Class<T> targetType) {
        return environment.getProperty(key, targetType);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        return environment.getProperty(key, targetType, defaultValue);
    }

    @Override
    public String getRequiredProperty(String key) throws IllegalStateException {
        return environment.getRequiredProperty(key);
    }

    @Override
    public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
        return environment.getRequiredProperty(key, targetType);
    }

    @Override
    public String resolvePlaceholders(String text) {
        return environment.resolvePlaceholders(text);
    }

    @Override
    public String resolveRequiredPlaceholders(String text) throws IllegalArgumentException {
        return environment.resolveRequiredPlaceholders(text);
    }
}
