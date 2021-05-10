package com.filos.users.utils.generators;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.filos.users.repository.model.BasicInformation;
import com.filos.users.repository.model.ContactInformation;
import com.filos.users.repository.model.DetailsSMS2FA;
import com.filos.users.repository.model.DetailsTOTP2FA;
import com.filos.users.repository.model.SecurityStatus;
import com.filos.users.repository.model.User;
import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.repository.status.StatusAccount;
import com.github.javafaker.Faker;

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
                   .BasicInfo(createBasicInformation())
                   .contactInfo(createContactInformation())
                   .security(createSecurityInformation())
                   .build();
    }

    private SecurityStatus createSecurityInformation() {
        return SecurityStatus.builder()
                             .password(faker.internet().password())
                             .level(SecurityLevel.BASIC_AUTH)
                             .statusAccount(StatusAccount.CREATED)
                             .detailsSMS2FA(DetailsSMS2FA.INITIAL)
                             .detailsTOTP2FA(DetailsTOTP2FA.INITIAL)
                             .build();
    }

    private ContactInformation createContactInformation() {
        return ContactInformation.builder()
                                 .email(faker.internet().emailAddress())
                                 .phoneNumber(faker.phoneNumber().phoneNumber())
                                 .build();
    }

    private BasicInformation createBasicInformation() {
        return BasicInformation.builder()
                               .username(faker.name().username())
                               .firstName(faker.name().firstName())
                               .lastName(faker.name().lastName())
                               .dateOfBirth(faker.date().birthday().toInstant())
                               .build();
    }

}
