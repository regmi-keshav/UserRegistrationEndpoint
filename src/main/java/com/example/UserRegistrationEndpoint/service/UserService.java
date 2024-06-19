package com.example.UserRegistrationEndpoint.service;

import com.example.UserRegistrationEndpoint.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> userStore = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        if (userStore.containsKey(user.getUsername())) {
            throw new RuntimeException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userStore.put(user.getUsername(), user);
    }

    public User fetchUser(String username) {
        User user = userStore.get(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}
