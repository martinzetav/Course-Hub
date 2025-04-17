package com.microservice.user.service.impl;

import com.microservice.user.dto.UserDTO;
import com.microservice.user.mapper.UserMapper;
import com.microservice.user.model.User;
import com.microservice.user.repository.IUserRepository;
import com.microservice.user.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO save(User user) {
        User savedUser = userRepository.save(user);
        UserDTO userDTO = userMapper.toDTO(savedUser);
        System.out.println(userDTO);
        return userDTO;
    }
}
