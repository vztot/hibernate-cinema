package com.vztot.cinema.security.impl;

import com.vztot.cinema.exception.AuthenticationException;
import com.vztot.cinema.lib.Inject;
import com.vztot.cinema.lib.Service;
import com.vztot.cinema.model.User;
import com.vztot.cinema.security.AuthenticationService;
import com.vztot.cinema.service.UserService;
import com.vztot.cinema.util.HashUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email);
        if (user.getPassword().equals(HashUtil.hashPassword(password, user.getSalt()))) {
            return user;
        }
        throw new AuthenticationException("Incorrect username or password");
    }

    @Override
    public User register(String email, String password) {
        return null;
    }
}
