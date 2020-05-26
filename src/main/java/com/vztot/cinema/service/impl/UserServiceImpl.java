package com.vztot.cinema.service.impl;

import com.vztot.cinema.dao.UserDao;
import com.vztot.cinema.lib.Inject;
import com.vztot.cinema.lib.Service;
import com.vztot.cinema.model.User;
import com.vztot.cinema.service.ShoppingCartService;
import com.vztot.cinema.service.UserService;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public User create(User user) {
        User registeredUser = userDao.add(user);
        shoppingCartService.registerNewShoppingCart(registeredUser);
        return registeredUser;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
