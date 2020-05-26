package com.vztot.cinema.service;

import com.vztot.cinema.model.MovieSession;
import com.vztot.cinema.model.ShoppingCart;
import com.vztot.cinema.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);
}
