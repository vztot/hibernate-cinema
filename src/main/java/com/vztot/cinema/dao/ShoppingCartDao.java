package com.vztot.cinema.dao;

import com.vztot.cinema.model.ShoppingCart;
import com.vztot.cinema.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
