package com.filos.users.services.api;

import org.springframework.scheduling.annotation.Async;

public interface ExternalNotifier {
    @Async
    void deleteUser(String id);

    @Async
    void createUser(String id);
}
