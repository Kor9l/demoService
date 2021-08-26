package com.example.demo.controller;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.request.UpdateUserRequest;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/user")
public class UserAdminController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody CreateUserRequest createUserRequest) {
        userService.create(createUserRequest);
        return new ResponseEntity<>(new MessageResponse("Created successfully"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(new MessageResponse("Delete successfully"), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<UserResponse> update(@RequestBody UpdateUserRequest updateUserRequest) {
        return new ResponseEntity<>(userService.update(updateUserRequest), HttpStatus.OK);

    }
}
