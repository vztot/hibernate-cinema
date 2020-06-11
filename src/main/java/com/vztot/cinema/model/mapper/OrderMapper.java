package com.vztot.cinema.model.mapper;

import com.vztot.cinema.model.Order;
import com.vztot.cinema.model.dto.response.OrderResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final UserMapper userMapper;
    private final TicketMapper ticketMapper;

    public OrderMapper(UserMapper userMapper, TicketMapper ticketMapper) {
        this.userMapper = userMapper;
        this.ticketMapper = ticketMapper;
    }

    public OrderResponseDto buildOrderResponseDtoFromOrder(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setUser(userMapper.buildUserResponseDtoFromUser(order.getUser()));
        dto.setLocalDate(order.getLocalDate());
        dto.setTickets(order.getTickets().stream()
                .map(ticketMapper::buildTicketResponseDtoFromTicket)
                .collect(Collectors.toList()));
        return dto;
    }
}
