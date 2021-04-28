package com.filos.users.services.notifiers.api;

import org.springframework.scheduling.annotation.Async;

import lombok.NonNull;

public interface ExternalNotifier {
    @Async
    void deleteUser(@NonNull String id);

    @Async
    void createUser(@NonNull String id);
}
