package com.filos.users.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsSMS2FA {
    private String phoneNumber;
    private boolean confirmed;
    public static final DetailsSMS2FA INITIAL = new DetailsSMS2FA(null, false);
}
