package com.vztot.cinema.service.impl;

import com.vztot.cinema.dao.UserDao;
import com.vztot.cinema.lib.Inject;
import com.vztot.cinema.lib.Service;
import com.vztot.cinema.model.User;
import com.vztot.cinema.service.UserService;
import com.vztot.cinema.util.HashUtil;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User create(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
