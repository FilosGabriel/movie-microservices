package com.filos.users.services.security.qr;

import java.security.SecureRandom;
import javax.validation.constraints.Min;

import com.google.common.io.BaseEncoding;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Token {
    private final SecureRandom secureRandom = new SecureRandom();

    public String generateSecure(@Min(10) int length) {
        byte[] token = new byte[length];
        secureRandom.nextBytes(token);
        return BaseEncoding.base32().encode(token);
    }
}
