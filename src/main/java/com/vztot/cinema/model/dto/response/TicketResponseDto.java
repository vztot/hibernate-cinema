package com.vztot.cinema.model.dto.response;

import lombok.Data;

@Data
public class TicketResponseDto {
    private Long id;
    private MovieSessionResponseDto movieSession;
    private UserResponseDto user;
}
