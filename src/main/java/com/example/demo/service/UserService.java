package com.example.demo.service;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.request.UpdateUserRequest;
import com.example.demo.dto.response.UserResponse;

public interface UserService {
    UserResponse getById(Long id);

    void deleteById(Long id);

    void create(CreateUserRequest createUserRequest);

    UserResponse update(UpdateUserRequest updateUserRequest);
}
