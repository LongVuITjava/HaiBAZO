package com.edu.serviceImpl;

import com.edu.model.User;
import com.edu.repository.UserRepository;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User authenticateUser(String email, String password) {
        // Fetch user by email
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Add proper password encryption comparison here (e.g., BCrypt)
            return user;
        }
        return null;
    }
}
