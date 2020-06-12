package com.vztot.cinema.model.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long id;
    private List<TicketResponseDto> tickets;
    private UserResponseDto user;
}
