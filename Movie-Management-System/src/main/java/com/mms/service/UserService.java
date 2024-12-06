package com.mms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entity.User;
import com.mms.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Register User
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Login User
    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    // Fetch User by userId
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
