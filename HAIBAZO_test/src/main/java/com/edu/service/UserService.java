package com.edu.service;

import java.util.List;
import java.util.Optional;

import com.edu.model.User;

public interface UserService {

	User authenticateUser(String email, String password);
}
