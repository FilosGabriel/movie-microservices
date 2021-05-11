package com.filos.users.services.security.api;

import com.filos.users.repository.model.User;
import com.filos.users.web.requests.LoginRequest;

public interface LoginMethodService {

    void tryToApproveLogin(LoginRequest loginRequest, User user);
}
