package com.user.service;

import com.user.dto.AuthRequest;
import com.user.dto.AuthResponse;
import com.user.dto.UserRequest;
import com.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse register(UserRequest request);

    AuthResponse login(AuthRequest request);

    UserResponse getUser(String username);

    List<UserResponse> getAllUsers();
}
