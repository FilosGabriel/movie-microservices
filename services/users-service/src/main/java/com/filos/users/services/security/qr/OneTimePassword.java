package com.filos.users.services.security.qr;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OneTimePassword {
    private final String KEY_URI_FORMAT = "otpauth://totp/%s:%s?secret=%s&issuer=%s";

    public String format(String org, String user, String secret) {
        return String.format(KEY_URI_FORMAT, org, user, secret, org);
    }
}
