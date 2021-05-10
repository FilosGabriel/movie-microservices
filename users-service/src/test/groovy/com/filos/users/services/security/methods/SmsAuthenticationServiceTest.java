package com.filos.users.services.security.methods;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.services.security.exceptions.InvalidLoginRequest;
import com.filos.users.services.utils.UserValidationSecurity;
import com.filos.users.utils.generators.UsersGenerator;
import com.filos.users.web.requests.LoginRequest;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class SmsAuthenticationServiceTest {

    private final UsersGenerator usersGenerator = new UsersGenerator();
    @Mock
    UserRepositoryMongo userRepositoryMongo;
    @Mock
    UserValidationSecurity userValidationSecurity;
    private final DigestUtils digestUtils = new DigestUtils(MessageDigestAlgorithms.SHA3_256);

    @Test
    @DisplayName("It should allow if is correct request")
    public void testWhenValid() {
        SmsAuthenticationService smsAuthenticationService = new SmsAuthenticationService(userRepositoryMongo, userValidationSecurity);
        User user = usersGenerator.createUser();
        LoginRequest loginRequest = new LoginRequest("test", "password", "basic", null);
        user.getSecurity().setPassword(digestUtils.digestAsHex(loginRequest.getPassword()));
        // When
        Assertions.assertThatCode(() -> smsAuthenticationService.tryToApproveLogin(loginRequest, user))
                  // Then
                  .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("it should not allow if request is invalid")
    public void testWhenInvalid() {
        BasicAuthenticationService basicAuthenticationService = new BasicAuthenticationService(
                digestUtils);
        User user = usersGenerator.createUser();
        LoginRequest loginRequest = new LoginRequest("test", "password", "basic", null);
        user.getSecurity().setPassword(digestUtils.digestAsHex("other password"));
        // When
        Assertions.assertThatThrownBy(() -> basicAuthenticationService.tryToApproveLogin(loginRequest, user))
                  // Then
                  .isInstanceOf(InvalidLoginRequest.class);
    }

}