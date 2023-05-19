package com.example.library.service;

import com.example.library.entity.UserRole;
import com.example.library.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    private final UserRoleRepository user_roleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository user_roleRepository) {
        this.user_roleRepository = user_roleRepository;
    }

    public void createUserRole(UserRole user_role) {
        user_roleRepository.createUserRole(user_role);
    }

    public List<UserRole> getUserRoles() {
        return user_roleRepository.getUserRoles();
    }

    public UserRole findById(int id) {
        return user_roleRepository.findById(id);
    }

    public void updateUserRole(int id, UserRole user_role) {
        user_roleRepository.updateUserRole(id, user_role);
    }
}
