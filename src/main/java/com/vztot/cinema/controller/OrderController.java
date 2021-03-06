package com.vztot.cinema.controller;

import com.vztot.cinema.model.ShoppingCart;
import com.vztot.cinema.model.User;
import com.vztot.cinema.model.dto.response.OrderResponseDto;
import com.vztot.cinema.model.mapper.OrderMapper;
import com.vztot.cinema.service.OrderService;
import com.vztot.cinema.service.ShoppingCartService;
import com.vztot.cinema.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final OrderMapper mapper;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService, UserService userService, OrderMapper mapper,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.userService = userService;
        this.mapper = mapper;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    private void completeOrder(Authentication auth) {
        User user = userService.getByEmail(auth.getName());
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        orderService.completeOrder(shoppingCart.getTickets(), user);
    }

    @GetMapping
    private List<OrderResponseDto> getHistoryForUserById(Authentication auth) {
        return orderService.getOrderHistory(userService.getByEmail(auth.getName())).stream()
                .map(mapper::buildOrderResponseDtoFromOrder)
                .collect(Collectors.toList());
    }
}
