package com.vztot.cinema.model.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    private List<TicketRequestDto> tickets;
    private UserRequestDto user;
}
