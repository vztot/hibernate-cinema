package com.vztot.cinema.model.mapper;

import com.vztot.cinema.model.ShoppingCart;
import com.vztot.cinema.model.dto.response.ShoppingCartResponseDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    private final TicketMapper ticketMapper;
    private final UserMapper userMapper;

    public ShoppingCartMapper(TicketMapper ticketMapper, UserMapper userMapper) {
        this.ticketMapper = ticketMapper;
        this.userMapper = userMapper;
    }

    public ShoppingCartResponseDto buildShoppingCartResponseDtoFromShoppingCart(
            ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(shoppingCart.getId());
        shoppingCartResponseDto.setTickets(shoppingCart.getTickets().stream()
                .map(ticketMapper::buildTicketResponseDtoFromTicket)
                .collect(Collectors.toList()));
        shoppingCartResponseDto.setUser(
                userMapper.buildUserResponseDtoFromUser(shoppingCart.getUser()));
        return shoppingCartResponseDto;
    }
}
