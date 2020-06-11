package com.vztot.cinema.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private List<TicketResponseDto> tickets;
    private UserResponseDto user;
    private LocalDateTime localDate;
}
