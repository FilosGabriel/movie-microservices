package com.filos.users.services.security.api;

import com.filos.users.repository.model.User;
import com.filos.users.web.requests.UserRequest;

public interface MethodSecurityService {
    void activate(User user,UserRequest request);
    void remove(User user,UserRequest request);
}
