package com.filos.services;

import com.filos.repository.UserRepositoryComposition;
import dto.UserDto;
import entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper mapper;
    private UserRepositoryComposition userRepository;

    public UserDto createUser(UserDto userDtoRequest) {
        User user = mapper.map(userDtoRequest, User.class);
        userRepository.createUser(user);
        return userDtoRequest;
    }
}
