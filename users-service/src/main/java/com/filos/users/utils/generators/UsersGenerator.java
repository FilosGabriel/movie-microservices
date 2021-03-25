package com.filos.users.utils.generators;

import com.filos.users.repository.model.User;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.google.common.base.Preconditions.checkArgument;

public class UsersGenerator {

    protected final Faker faker;

    public UsersGenerator() {
        faker = Faker.instance();
    }

    public List<User> generateUsers(int noOfUsers) {
        checkArgument(noOfUsers >= 0);
        return LongStream.range(0, noOfUsers)
                .mapToObj(i -> createUser())
                .collect(Collectors.toList());
    }

    public User createUser() {
        return User.builder()
                .id(UUID.randomUUID().toString())
                .username(faker.name().username())
                .dateOfBirth(faker.date().birthday().toInstant())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .build();
    }

}
