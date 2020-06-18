package com.vztot.cinema.service.impl;

import com.vztot.cinema.dao.RoleDao;
import com.vztot.cinema.model.Role;
import com.vztot.cinema.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

    @Override
    public Role getById(Long roleId) {
        return roleDao.getById(roleId);
    }
}
