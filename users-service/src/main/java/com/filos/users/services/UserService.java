package com.filos.users.services;

import com.filos.domain.dto.UserDto;
import com.filos.domain.entities.User;
import com.filos.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper mapper;
    private UserRepository userRepository;

    public UserDto createUser(UserDto userDtoRequest) {
        User user = mapper.map(userDtoRequest, User.class);
        userRepository.createUser(user);
        return userDtoRequest;
    }
}
