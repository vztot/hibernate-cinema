package com.vztot.cinema.controller;

import com.vztot.cinema.model.Role;
import com.vztot.cinema.model.User;
import com.vztot.cinema.service.RoleService;
import com.vztot.cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InjectDataController {
    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public InjectDataController(RoleService roleService, UserService userService,
                                PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    void injectRolesAndUsers() {
        injectRoles();
        injectUsers();
    }

    private void injectRoles() {
        roleService.add(Role.of("USER"));
        roleService.add(Role.of("ADMIN"));
    }

    private void injectUsers() {
        User admin = new User();
        User user = new User();
        admin.setEmail("admin@gmail.com");
        user.setEmail("user@gmail.com");
        admin.setPassword(passwordEncoder.encode("1111"));
        user.setPassword(passwordEncoder.encode("2222"));
        admin.setRoles(Set.of(roleService.getRoleByName("ADMIN")));
        user.setRoles(Set.of(roleService.getRoleByName("USER")));
        userService.create(admin);
        userService.create(user);
    }
}
