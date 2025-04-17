package com.microservice.user.service.interfaces;

import com.microservice.user.dto.UserDTO;
import com.microservice.user.model.User;

public interface IUserService {
    UserDTO save(User user);
}
