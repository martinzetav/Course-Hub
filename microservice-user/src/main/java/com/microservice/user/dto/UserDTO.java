package com.microservice.user.dto;

import com.microservice.user.model.Role;

import java.time.LocalDateTime;

public record UserDTO(Long id,
                      String username,
                      String email,
                      Role role,
                      LocalDateTime createdAt) {
}
