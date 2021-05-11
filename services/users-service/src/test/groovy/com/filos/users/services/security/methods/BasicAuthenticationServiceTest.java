package com.filos.users.services.security.methods;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.filos.users.repository.model.User;
import com.filos.users.services.security.exceptions.InvalidLoginRequest;
import com.filos.users.utils.generators.UsersGenerator;
import com.filos.users.web.requests.LoginRequest;

@DisplayName("When a user try to auth using basic")
class BasicAuthenticationServiceTest {

    private final UsersGenerator usersGenerator = new UsersGenerator();
    private final DigestUtils digestUtils = new DigestUtils(MessageDigestAlgorithms.SHA3_256);

    @Test
    @DisplayName("It should allow if is correct request")
    public void testWhenValid() {
        BasicAuthenticationService basicAuthenticationService = new BasicAuthenticationService(
                digestUtils);
        User user = usersGenerator.createUser();
        LoginRequest loginRequest = new LoginRequest("test", "password", "basic", null);
        user.getSecurity().setPassword(digestUtils.digestAsHex(loginRequest.getPassword()));
        // When
        Assertions.assertThatCode(() -> basicAuthenticationService.tryToApproveLogin(loginRequest, user))
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