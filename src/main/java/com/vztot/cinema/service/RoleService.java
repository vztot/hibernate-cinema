package com.vztot.cinema.service;

import com.vztot.cinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
