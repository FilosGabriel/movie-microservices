package com.filos.users.services;

import com.filos.domain.dto.UserDto;
import com.filos.domain.dto.UserQRCodeDto;
import com.filos.requests.users.FindUser;
import com.filos.users.repository.model.SecurityStatus;
import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper mapper;
    private final UserRepositoryMongo userRepository;

    public UserQRCodeDto createUser(UserDto userDtoRequest) {
        User user = mapper.map(userDtoRequest, User.class);
        user.setSecurity(SecurityStatus.initialStatus());
        userRepository.save(user);
        return mapper.map(userDtoRequest, UserQRCodeDto.class);
    }

    public void checkExistenceOfUser(FindUser user) {
        userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail())
                .orElseThrow(NotImplementedException::new);
    }
}
