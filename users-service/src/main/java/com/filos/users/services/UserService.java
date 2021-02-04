package com.filos.users.services;

import com.filos.users.repository.model.User;
import com.filos.users.repository.composite.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public UserQRCodeDto createUser(UserDto userDtoRequest) {
        User user = mapper.map(userDtoRequest, User.class);
        user.setId(UUID.randomUUID());
        userRepository.createUser(user);
        return mapper.map(userDtoRequest, UserQRCodeDto.class);
    }
}
