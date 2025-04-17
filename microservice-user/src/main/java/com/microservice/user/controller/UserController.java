package com.microservice.user.controller;

import com.microservice.user.dto.UserDTO;
import com.microservice.user.model.User;
import com.microservice.user.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

}
