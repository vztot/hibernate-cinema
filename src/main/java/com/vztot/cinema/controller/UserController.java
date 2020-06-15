package com.vztot.cinema.controller;

import com.vztot.cinema.model.dto.response.UserResponseDto;
import com.vztot.cinema.model.mapper.UserMapper;
import com.vztot.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/byemail")
    private UserResponseDto getUserByEmail(@RequestParam String email) {
        return mapper.buildUserResponseDtoFromUser(userService.getByEmail(email));
    }
}
