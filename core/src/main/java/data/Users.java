package data;

import com.github.javafaker.Faker;
import entities.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Users {
    public static List<User> createUsers(int size) {
        Faker faker = Faker.instance();
        return LongStream.range(0, size)
                .mapToObj(index -> createUser(faker))
                .collect(Collectors.toList());

    }

    public static User createUser(Faker faker) {
        return User.builder()
                .email(faker.internet().emailAddress())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .password(faker.internet().password())
                .id(UUID.randomUUID())
                .username(faker.name().username())
                .dateOfBirth(getDateOfBirth(faker))
                .build();
    }

    private static LocalDate getDateOfBirth(Faker faker) {
        return faker
                .date()
                .birthday()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
