package com.vztot.cinema.service.impl;

import com.vztot.cinema.dao.UserDao;
import com.vztot.cinema.model.User;
import com.vztot.cinema.service.ShoppingCartService;
import com.vztot.cinema.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private ShoppingCartService shoppingCartService;

    @Autowired
    public UserServiceImpl(UserDao userDao, ShoppingCartService shoppingCartService) {
        this.userDao = userDao;
        this.shoppingCartService = shoppingCartService;
    }

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
