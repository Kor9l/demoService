package com.example.demo.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TechnicResponse {
    private Integer id;
    private String model;
    private Integer brandId;
}
