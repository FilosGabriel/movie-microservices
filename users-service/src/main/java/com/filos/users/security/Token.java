package com.filos.users.users.utils.security;

import com.google.common.io.BaseEncoding;
import lombok.experimental.UtilityClass;

import java.security.SecureRandom;
import java.util.Base64;

@UtilityClass
public class Token {
    private final SecureRandom secureRandom = new SecureRandom();

    public String generateSecure(int length) {
        byte[] token = new byte[length];
        secureRandom.nextBytes(token);
        return BaseEncoding.base32().encode(token);
    }
}
