package com.filos.users.repository.composite;

import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserRepositoryMongo userRepositoryMongo;

    public void createUser(User user) {
        userRepositoryMongo.save(user);
    }

}
