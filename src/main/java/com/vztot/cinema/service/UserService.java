package com.vztot.cinema.service;

import com.vztot.cinema.model.User;

public interface UserService {
    User create(User user);

    User findByEmail(String email);

    User getById(Long userId);
}
