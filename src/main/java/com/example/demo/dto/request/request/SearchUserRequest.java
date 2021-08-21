package com.example.demo.dto.request.request;


import com.example.demo.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchUserRequest {
    private String email;
    private Role role;
}
