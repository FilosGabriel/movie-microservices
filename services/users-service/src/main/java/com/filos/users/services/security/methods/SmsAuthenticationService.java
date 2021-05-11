package com.filos.users.services.security.methods;

import org.springframework.stereotype.Service;

import com.filos.users.repository.model.DetailsSMS2FA;
import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.services.security.api.LoginMethodService;
import com.filos.users.services.security.api.MethodSecurityService;
import com.filos.users.services.security.exceptions.AlreadyActivated;
import com.filos.users.services.security.exceptions.AlreadyRemoved;
import com.filos.users.services.security.exceptions.MethodCantBeRemoved;
import com.filos.users.services.utils.UserValidationSecurity;
import com.filos.users.utils.extensions.UserExtension;
import com.filos.users.web.requests.LoginRequest;
import com.filos.users.web.requests.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;

@Service("sms")
@ExtensionMethod(UserExtension.class)
@RequiredArgsConstructor
public class SmsAuthenticationService implements LoginMethodService, MethodSecurityService {
    private final UserRepositoryMongo userRepository;
    private final UserValidationSecurity userValidationSecurity;

    @Override
    public void tryToApproveLogin(LoginRequest loginRequest, User user) {

    }

    @Override
    public void activate(User user, UserRequest request) {
        user.checkSecurityLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_SMS)
            .ifEqualsThrow(AlreadyActivated::sms);
        userValidationSecurity.checkIfHasAllNecessaryDataForSMS2FA(user);
        user.getSecurity().setLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_SMS);
        String phoneNumber = user.getContactInfo().getPhoneNumber();
        user.getSecurity().getDetailsSMS2FA().setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }

    @Override
    public void remove(User user, UserRequest request) {
        user.checkSecurityLevel(SecurityLevel.BASIC_AUTH)
            .ifEqualsThrow(AlreadyRemoved::sms);
        user.checkSecurityLevel(SecurityLevel.TWO_FACTOR_AUTHENTICATION_QR_CODE)
            .ifEqualsThrow(MethodCantBeRemoved::sms);
        user.getSecurity().setDetailsSMS2FA(DetailsSMS2FA.INITIAL);
        user.getSecurity().setLevel(SecurityLevel.BASIC_AUTH);
    }
}
