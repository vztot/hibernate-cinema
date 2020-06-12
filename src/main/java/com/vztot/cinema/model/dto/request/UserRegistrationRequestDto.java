package com.vztot.cinema.model.dto.request;

import lombok.Data;

@Data
public class UserRegistrationRequestDto {
    private String login;
    private String password;
}
