package com.vztot.cinema.service;

import com.vztot.cinema.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> findByEmail(String email);

    List<User> getAll();
}
