package com.vztot.cinema.security.impl;

import com.vztot.cinema.dao.UserDao;
import com.vztot.cinema.exception.AuthenticationException;
import com.vztot.cinema.model.User;
import com.vztot.cinema.security.AuthenticationService;
import com.vztot.cinema.service.RoleService;
import com.vztot.cinema.service.UserService;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserDao userDao;
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public AuthenticationServiceImpl(UserDao userDao, UserService userService,
                                     PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userDao = userDao;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userDao.getByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Incorrect username or password"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new AuthenticationException("Incorrect username or password");
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of(roleService.getRoleByName("USER")));
        return userService.create(user);
    }
}
