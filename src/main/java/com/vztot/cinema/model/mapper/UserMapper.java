package com.vztot.cinema.model.mapper;

import com.vztot.cinema.model.User;
import com.vztot.cinema.model.dto.response.UserResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto buildUserResponseDtoFromUser(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles().stream()
                .map(role -> role.getRoleName().toString())
                .collect(Collectors.toSet()));
        return dto;
    }
}
