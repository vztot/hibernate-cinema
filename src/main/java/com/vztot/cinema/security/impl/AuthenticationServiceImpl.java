package com.vztot.cinema.security.impl;

import com.vztot.cinema.dao.UserDao;
import com.vztot.cinema.exception.AuthenticationException;
import com.vztot.cinema.model.User;
import com.vztot.cinema.security.AuthenticationService;
import com.vztot.cinema.service.UserService;
import com.vztot.cinema.util.HashUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserDao userDao;
    private UserService userService;

    public AuthenticationServiceImpl(UserDao userDao, UserService userService) {
        this.userDao = userDao;
        this.userService = userService;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userDao.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Incorrect username or password"));
        if (user.getPassword().equals(HashUtil.hashPassword(password, user.getSalt()))) {
            return user;
        }
        throw new AuthenticationException("Incorrect username or password");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(password, user.getSalt()));
        return userService.create(user);
    }
}
