package com.filos.users.repository.migrations;

import com.filos.users.utils.generators.UsersGenerator;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v2.decorator.impl.MongockTemplate;
import io.changock.migration.api.annotations.ChangeLog;
import io.changock.migration.api.annotations.ChangeSet;
import io.changock.migration.api.annotations.NonLockGuarded;

@ChangeLog(order = "001")
public class PopulateDatabase {

    @ChangeSet(order = "001", id = "load 100 users", author = "Filos Gabriel")
    public void load100Users(MongockTemplate mongockTemplate,  @NonLockGuarded UsersGenerator generator) {
        mongockTemplate.insertAll(generator.generateUsers(100));
    }

}
