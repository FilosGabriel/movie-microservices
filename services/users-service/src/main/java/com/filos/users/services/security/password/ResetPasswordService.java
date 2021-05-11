package com.filos.users.services.security.password;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.filos.users.repository.model.ResetData;
import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.ResetDataRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResetPasswordService {
    private final ResetDataRepository repository;

    public ResetData generateResetCode(User user) {
        UUID uuid = UUID.randomUUID();
        ResetData resetData = ResetData.of(user.getId(), uuid.toString());
        repository.save(resetData);
        return resetData;
    }

}
