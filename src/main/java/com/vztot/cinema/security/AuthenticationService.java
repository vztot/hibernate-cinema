package com.vztot.cinema.security;

import com.vztot.cinema.exception.AuthenticationException;
import com.vztot.cinema.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password);
}
