package com.user.controller;

import com.user.dto.*;
import com.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(
            @Valid @RequestBody UserRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true,
                        "User registered",
                        service.register(request)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @Valid @RequestBody AuthRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Login successful",
                        service.login(request)));
    }


    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserResponse>> getMyDetails(Authentication auth) {
        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "User fetched",
                        service.getUser(auth.getName())));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "All users fetched",
                        service.getAllUsers()));
    }
}

