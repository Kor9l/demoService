package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchClientRequest {

    private String fullName;

    private String email;
}
