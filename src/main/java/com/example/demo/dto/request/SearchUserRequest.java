package com.example.demo.dto.request;


import com.example.demo.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchUserRequest {
    private String email;
    private Role role;
}
