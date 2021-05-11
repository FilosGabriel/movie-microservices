package com.filos.users.repository.listeners;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import com.filos.users.repository.model.User;
import com.filos.users.utils.generators.UsersGenerator;

@DisplayName("when a user is saved")
class HideSecretsOnSaveListenerTest {

    @Test
    @DisplayName(" the password should be hashed")
    public void test() {
        // Given
        HideSecretsOnSaveListener hideSecretsOnSaveListener = new HideSecretsOnSaveListener(
                new DigestUtils(MessageDigestAlgorithms.SHA3_256));
        UsersGenerator usersGenerator = new UsersGenerator();
        User user = usersGenerator.createUser();
        String password = user.getSecurity().getPassword();
        // When
        hideSecretsOnSaveListener.onBeforeConvert(new BeforeConvertEvent<>(user, "collectionName"));
        // Then
        assertThat(user.getSecurity().getPassword()).isNotEqualTo(password);

    }
}