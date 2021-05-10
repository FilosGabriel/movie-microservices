package com.filos.users.repository.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.repository.status.StatusAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Getter
@Setter
@Document
@Accessors(chain = true)
public class SecurityStatus {
    @Indexed
    private @NonNull String password;
    private @NonNull SecurityLevel level;
    private @NonNull StatusAccount statusAccount;
    private @NonNull DetailsSMS2FA detailsSMS2FA;
    private @NonNull DetailsTOTP2FA detailsTOTP2FA;

    public static SecurityStatus initialStatus() {
        return SecurityStatus.builder()
                             .level(SecurityLevel.BASIC_AUTH)
                             .statusAccount(StatusAccount.CREATED)
                             .build();
    }
}
