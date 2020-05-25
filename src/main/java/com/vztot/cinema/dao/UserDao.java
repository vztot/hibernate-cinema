package com.vztot.cinema.dao;

import com.vztot.cinema.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    List<User> getAll();
}
