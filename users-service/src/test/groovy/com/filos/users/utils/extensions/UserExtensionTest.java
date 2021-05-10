package com.filos.users.utils.extensions;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.filos.users.repository.model.User;
import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.utils.generators.UsersGenerator;
import lombok.experimental.ExtensionMethod;

@DisplayName("When checkSecurityLevel is called")
@ExtensionMethod(UserExtension.class)
class UserExtensionTest {
    private final UsersGenerator usersGenerator = new UsersGenerator();

    @Test
    @DisplayName("then it should throw a exception when condition is true")
    public void equalThrow() {
        User user = usersGenerator.createUser();
        user.getSecurity().setLevel(SecurityLevel.BASIC_AUTH);
        assertThatThrownBy(() -> UserExtension.checkSecurityLevel(user, SecurityLevel.BASIC_AUTH)
                                              .ifEqualsThrow(RuntimeException::new))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("then it shouldn't throw a exception when condition is false")
    public void notEqualThrow() {
        User user = usersGenerator.createUser();
        user.getSecurity().setLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_SMS);
        assertThatCode(() -> UserExtension.checkSecurityLevel(user, SecurityLevel.BASIC_AUTH)
                                          .ifEqualsThrow(RuntimeException::new))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("it should do something when condition is true")
    public void testDoSomethingTrue() {
        User user = usersGenerator.createUser();
        user.getSecurity().setLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_SMS);
        assertThatThrownBy(() -> UserExtension.checkSecurityLevel(user, SecurityLevel.BASIC_AUTH)
                                              .doAction(u -> {
                                                  throw new RuntimeException();
                                              })).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("it shouldn't do something when condition is false")
    public void testDoSomethingFalse() {
        User user = usersGenerator.createUser();
        user.getSecurity().setLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_SMS);
        assertThatCode(() -> UserExtension.checkSecurityLevel(user, SecurityLevel.BASIC_AUTH)
                                              .doAction(u -> {
                                              }))
                .doesNotThrowAnyException();
    }

}