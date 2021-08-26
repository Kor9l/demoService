package com.example.demo.dto.request;

import lombok.Data;

@Data
public class CreateClientRequest {

    private Integer id;
    private String fullName;

    private String email;

    private Long telNumber;
}
