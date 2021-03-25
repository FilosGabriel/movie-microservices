package com.filos.users.repository.mongo;

import com.filos.users.repository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositoryMongo extends MongoRepository<User, UUID> {

    Optional<User> findByUsernameOrEmail(String userName,String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
