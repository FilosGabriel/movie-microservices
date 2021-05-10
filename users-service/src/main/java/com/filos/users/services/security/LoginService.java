package com.filos.users.services.security;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.services.security.api.LoginMethodService;
import com.filos.users.services.security.exceptions.InvalidLoginRequest;
import com.filos.users.services.validators.Validations;
import com.filos.users.web.requests.LoginRequest;
import com.filos.users.web.responses.TwoResponse;
import com.filos.users.web.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepositoryMongo userRepository;
    private final Map<String, LoginMethodService> methodsService;

    public TwoResponse approveLogin(LoginRequest loginRequest) {
        Validations.checkOrThrow(!methodsService.containsKey(loginRequest.getMethod()), InvalidLoginRequest::method);
        User user = userRepository.findByBasicInfo_UsernameOrContactInfo_Email(loginRequest.getUsername(), loginRequest.getUsername())
                                  .orElseThrow(UserNotFound::new);
        methodsService.get(loginRequest.getMethod()).tryToApproveLogin(loginRequest, user);
        return null;
    }
}
