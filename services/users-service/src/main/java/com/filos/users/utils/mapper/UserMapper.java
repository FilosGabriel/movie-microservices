package com.filos.users.utils.mapper;

import org.mapstruct.Mapper;

import com.filos.domain.dto.UserDto;
import com.filos.domain.dto.UserQRCodeDto;
import com.filos.users.repository.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);

    UserQRCodeDto toResponse(UserDto userDto);
}
