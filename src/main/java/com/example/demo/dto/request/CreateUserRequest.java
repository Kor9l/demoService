package com.example.demo.dto.request;

import com.example.demo.enums.Role;
import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String fullName;
    private String password;
    private Role role;

}
