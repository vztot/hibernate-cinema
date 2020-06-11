package com.vztot.cinema.controller;

import com.vztot.cinema.model.dto.request.UserRegistrationRequestDto;
import com.vztot.cinema.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    private void getUserByEmail(@RequestBody UserRegistrationRequestDto dto) {
        authenticationService.register(dto.getLogin(), dto.getPassword());
    }
}
