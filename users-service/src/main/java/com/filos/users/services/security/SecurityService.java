package com.filos.users.services.security;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.repository.status.SecurityLevel;
import com.filos.users.services.security.api.MethodSecurityService;
import com.filos.users.services.security.exceptions.InvalidLoginRequest;
import com.filos.users.utils.extensions.UserExtension;
import com.filos.users.web.exceptions.UserNotFound;
import com.filos.users.web.requests.UserRequest;
import com.filos.users.web.responses.TwoResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;

@Service
@RequiredArgsConstructor
@ExtensionMethod(UserExtension.class)
public class SecurityService {

    private final Map<String, MethodSecurityService> methodSecurityService;
    private final UserRepositoryMongo userRepository;

    public TwoResponse activateMethod(@NonNull UserRequest request) {
        User user = userRepository.findByContactInfo_Email(request.getMethod())
                                  .orElseThrow(UserNotFound::new);
        if (!methodSecurityService.containsKey(request.getMethod())) {
            throw InvalidLoginRequest.method();
        }
        methodSecurityService.get(request.getMethod()).activate(user, request);
        userRepository.save(user);
        return TwoResponse.with(request.getMethod(), user.getSecurity().getLevel().name());
    }

    public @NonNull SecurityLevel getStatusSMS2FA(UserRequest request) {
        User user = userRepository.findByContactInfo_Email(request.getEmail())
                                  .orElseThrow(UserNotFound::new);
        return user.getSecurity().getLevel();
    }

}
