package com.example.library.service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public void updateUser(int id, User user) {
        userRepository.updateUser(id, user);
    }
}
