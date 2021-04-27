package com.filos.users.services.user;

import org.springframework.stereotype.Service;

import com.filos.domain.dto.UserDto;
import com.filos.domain.dto.UserQRCodeDto;
import com.filos.requests.users.FindUser;
import com.filos.users.repository.model.SecurityStatus;
import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.utils.mapper.UserMapper;
import com.filos.users.web.exceptions.UserNotFound;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final UserRepositoryMongo userRepository;

    public UserQRCodeDto createUser(@NonNull UserDto userDtoRequest) {
        User user = mapper.toUser(userDtoRequest);
        user.setSecurity(SecurityStatus.initialStatus());
        userRepository.save(user);
        return mapper.toResponse(userDtoRequest);
    }

    public void checkExistenceOfUser(@NonNull FindUser user) {
        userRepository.findByBasicInfo_UsernameOrContactInfo_Email(user.getUsername(), user.getEmail())
                      .orElseThrow(UserNotFound::new);
    }
}
