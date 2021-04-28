package com.filos.users.utils.generators;

import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base32;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecretGenerator {
    private final SecureRandom randomByteGenerator = new SecureRandom();
    private final int noCharacters;
    private final Base32 encoder = new Base32();

    public SecretGenerator() {
        noCharacters = 32;
    }

    public String generate() {
        byte[] bytes = new byte[(noCharacters * 5) / 8];
        randomByteGenerator.nextBytes(bytes);
        return new String(encoder.encode(bytes));
    }

}
