package com.vztot.cinema.service;

import com.vztot.cinema.model.User;
import java.util.List;

public interface UserService {
    User create(User user);

    User findByEmail(String email);

    List<User> getAll();
}
