package com.example.demo.dto.request.request;


import com.example.demo.Role;
import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String fullName;
    private String password;
    private Role role;

}
