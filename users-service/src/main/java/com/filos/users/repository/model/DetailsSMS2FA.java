package com.filos.users.repository.model;

import lombok.Data;

@Data
public class DetailsSMS2FA {
    private String phoneNumber;
    private boolean confirmed;
}
