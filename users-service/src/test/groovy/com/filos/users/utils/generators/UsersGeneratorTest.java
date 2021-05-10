package com.filos.users.utils.generators;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.filos.users.repository.model.User;

class UsersGeneratorTest {
    @Test
    public void test() {
        // Given
        UsersGenerator usersGenerator = new UsersGenerator();
        // When
        List<User> users = usersGenerator.generateUsers(1);
        // Then
        assertThat(users).hasSize(1);
    }

}