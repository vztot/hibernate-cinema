package com.vztot.cinema.service;

import com.vztot.cinema.model.User;

public interface UserService {
    User create(User user);

    User getByEmail(String email);

    User getById(Long userId);
}
