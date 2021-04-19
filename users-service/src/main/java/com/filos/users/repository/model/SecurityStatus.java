package com.filos.users.repository.model;

import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.repository.status.StatusAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document
public class SecurityStatus {
    private SecurityLevel level;
    private StatusAccount statusAccount;
    private DetailsSMS2FA detailsSMS2FA;
    private DetailsTOTP2FA detailsTOTP2FA;

    public static SecurityStatus initialStatus() {
        return SecurityStatus.builder()
                .level(SecurityLevel.BASIC_AUTH)
                .statusAccount(StatusAccount.CREATED)
                .build();
    }
}
