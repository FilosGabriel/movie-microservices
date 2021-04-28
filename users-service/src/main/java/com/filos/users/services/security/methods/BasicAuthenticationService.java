package com.filos.users.services.security.methods;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.filos.users.config.constants.Services;
import com.filos.users.repository.model.User;
import com.filos.users.services.security.api.LoginMethodService;
import com.filos.users.services.security.exceptions.InvalidLoginRequest;
import com.filos.users.web.requests.LoginRequest;
import lombok.RequiredArgsConstructor;

@Component
@Service()
@RequiredArgsConstructor
public class BasicAuthenticationService implements LoginMethodService {
    @Qualifier(Services.Encryption.SHA)
    private final DigestUtils digestUtils;

    @Override
    public void tryToApproveLogin(LoginRequest loginRequest, User user) {
        String requestPassword = digestUtils.digestAsHex(loginRequest.getPassword());
        if (!requestPassword.equals(user.getSecurity().getPassword())) {
            throw InvalidLoginRequest.password();
        }
    }
}
