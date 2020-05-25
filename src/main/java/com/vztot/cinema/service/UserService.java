package com.vztot.cinema.service;

import com.vztot.cinema.model.User;
import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> findByEmail(String email);
}
