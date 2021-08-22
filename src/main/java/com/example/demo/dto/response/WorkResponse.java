package com.example.demo.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkResponse {
    private Integer id;
    private String title;
    private Double price;
}
