package com.filos.users.repository.mongo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.filos.users.repository.model.User;

@Repository
public interface UserRepositoryMongo extends MongoRepository<User, UUID> {

    @Query("{'$or':[{'basicInfo':{ 'username':?0}},{'contactInfo': ?1}]}")
    Optional<User> findByCustom(String username, String email);

    Optional<User> findByBasicInfo_UsernameOrContactInfo_Email(String username, String email);

    Optional<User> findByContactInfo_Email(String email);

    Optional<User> findByBasicInfo_Username(String username);

}
