package com.filos.users.services.security;

import org.springframework.stereotype.Service;

import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.services.utils.UserValidationSecurity;
import com.filos.users.web.dto.TwoResponse;
import com.filos.users.web.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserRepositoryMongo userRepository;
    private final UserValidationSecurity userValidationSecurity;

    public TwoResponse getStatusSMS2FA() {
        User user = userRepository.findByContactInfo_Email("email").orElseThrow(UserNotFound::new);
        return TwoResponse.with("SMS", user.getSecurity().getLevel().name());
    }

    public void enableSMS2FA() {
        User user = userRepository.findByContactInfo_Email("email").orElseThrow(UserNotFound::new);
        userValidationSecurity.checkIfHasAllNecessaryDataForSMS2FA(user);
        user.getSecurity().setLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_SMS);
        userRepository.save(user);
    }

    public void enableTOTP2FA() {
        User user = userRepository.findByContactInfo_Email("email").orElseThrow(UserNotFound::new);
    }
}
