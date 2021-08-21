package com.example.demo.dto.request;

import lombok.Data;

@Data
public class CreateClientRequest {

    private String fullName;

    private String email;

    private Integer telNumber;
}
