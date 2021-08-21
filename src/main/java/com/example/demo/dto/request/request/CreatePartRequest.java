package com.example.demo.dto.request.request;

import lombok.Data;

@Data
public class CreatePartRequest {
    private String partNumber;
    private String title;
    private Double price;
}
