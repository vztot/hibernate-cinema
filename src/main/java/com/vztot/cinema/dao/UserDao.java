package com.vztot.cinema.dao;

import com.vztot.cinema.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> getByEmail(String email);

    Optional<User> getById(Long userId);
}
