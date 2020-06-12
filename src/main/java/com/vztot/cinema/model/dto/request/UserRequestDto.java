package com.vztot.cinema.model.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private Long id;
    private String email;
    private String password;
    private byte[] salt;
}
