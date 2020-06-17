package com.vztot.cinema.dao;

import com.vztot.cinema.model.Role;

public interface RoleDao {
    Role getRoleByName(String roleName);

    Role add(Role role);
}
