package com.vztot.cinema.model.dto.response;

import java.util.Set;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private Set<String> roles;
}
