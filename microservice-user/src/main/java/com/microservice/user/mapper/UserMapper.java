package com.microservice.user.mapper;

import com.microservice.user.dto.UserDTO;
import com.microservice.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
