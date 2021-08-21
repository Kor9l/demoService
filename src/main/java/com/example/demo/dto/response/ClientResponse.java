package com.example.demo.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientResponse {
    private Integer id;
    private String fullName;
    private String email;
    private Integer telNumber;
}
