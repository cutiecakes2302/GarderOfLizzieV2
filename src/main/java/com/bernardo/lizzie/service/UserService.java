package com.bernardo.lizzie.service;

import com.bernardo.lizzie.entity.User;

public interface UserService {
    User register(User user);
    User login(String email, String rawPassword);
}
