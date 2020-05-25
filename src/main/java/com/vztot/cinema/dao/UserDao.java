package com.vztot.cinema.dao;

import com.vztot.cinema.model.User;
import java.util.List;

public interface UserDao {
    User add(User user);

    User findByEmail(String email);

    List<User> getAll();
}
