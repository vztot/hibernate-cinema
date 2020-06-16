package com.vztot.cinema.controller;

import com.vztot.cinema.model.dto.request.UserRegistrationRequestDto;
import com.vztot.cinema.security.AuthenticationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/register")
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    private void registerUser(@RequestBody @Valid UserRegistrationRequestDto dto) {
        authenticationService.register(dto.getEmail(), dto.getPassword());
    }
}
