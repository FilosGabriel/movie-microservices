package com.filos.users.repository.mongo;

import com.filos.users.repository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositoryMongo extends MongoRepository<User, UUID> {
}
