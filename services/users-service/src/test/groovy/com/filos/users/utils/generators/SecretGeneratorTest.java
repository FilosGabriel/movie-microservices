package com.filos.users.utils.generators;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SecretGeneratorTest {
    @Test
    public void test() {

        // Given
        SecretGenerator secretGenerator = new SecretGenerator();
        // Then
        String secrete = secretGenerator.generate();
        // Then
        assertThat(secrete).isNotBlank();
    }

    @Test
    @DisplayName("is generated with a length it should have that lengtg")
    public void generatorWithInit() {
        // Given
        SecretGenerator secretGenerator = new SecretGenerator(44);
        // When
        String secret = secretGenerator.generate();
        // Then
        assertThat(secret).hasSize(44);
    }
}