package com.filos.users.services.security.methods;

import org.springframework.stereotype.Service;

import com.filos.users.repository.model.User;
import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.services.security.api.LoginMethodService;
import com.filos.users.services.security.api.MethodSecurityService;
import com.filos.users.services.security.exceptions.AlreadyActivated;
import com.filos.users.utils.extensions.UserExtension;
import com.filos.users.utils.generators.SecretGenerator;
import com.filos.users.web.requests.LoginRequest;
import com.filos.users.web.requests.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;

@ExtensionMethod(UserExtension.class)
@Service
@RequiredArgsConstructor
public class TotpAuthenticationService implements LoginMethodService, MethodSecurityService {
    private final SecretGenerator secretGenerator;
    private final SmsAuthenticationService smsAuthenticationService;

    @Override
    public void tryToApproveLogin(LoginRequest loginRequest, User user) {
    }

    @Override
    public void activate(User user, UserRequest request) {
        user.checkSecurityLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_QR_CODE)
            .ifEqualsThrow(AlreadyActivated::totp);
        user.checkSecurityLevel(SecurityLevel.BASIC_AUTH)
            .doAction((u) -> smsAuthenticationService.activate(u, request));
        user.getSecurity().getDetailsTOTP2FA().setSecret(secretGenerator.generate());
        user.getSecurity().setLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_QR_CODE);

    }
}
