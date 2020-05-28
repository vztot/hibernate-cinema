package com.vztot.cinema.service;

import com.vztot.cinema.model.Order;
import com.vztot.cinema.model.Ticket;
import com.vztot.cinema.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(List<Ticket> tickets, User user);

    List<Order> getOrderHistory(User user);
}
