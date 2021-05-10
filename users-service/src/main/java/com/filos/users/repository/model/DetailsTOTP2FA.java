package com.filos.users.repository.model;

import java.sql.Timestamp;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsTOTP2FA {
    public static final DetailsTOTP2FA INITIAL = new DetailsTOTP2FA(null, Timestamp.from(Instant.now()));
    private String secret;
    private Timestamp timestamp;
}
