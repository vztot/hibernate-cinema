package com.vztot.cinema.dao;

import com.vztot.cinema.model.Order;
import com.vztot.cinema.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getByUser(User user);
}
