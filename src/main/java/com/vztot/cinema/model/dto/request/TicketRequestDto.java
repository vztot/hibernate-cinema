package com.vztot.cinema.model.dto.request;

import lombok.Data;

@Data
public class TicketRequestDto {
    private Long id;
    private MovieSessionRequestDto movieSession;
    private UserRequestDto user;
}
