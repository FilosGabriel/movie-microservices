package com.filos.users.repository.migrations;

import com.filos.domain.generators.UsersGenerator;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog(order = "001")
public class PopulateDatabase extends MongoMigration {

    @ChangeSet(order = "001", id = "001", author = "Filos Gabriel")
    public void load100Users(MongoTemplate db, final Environment environment) {
        UsersGenerator generator = getApplicationContext(environment).getBean(UsersGenerator.class);
        db.insertAll(generator.generateUsers(100));
    }

}
