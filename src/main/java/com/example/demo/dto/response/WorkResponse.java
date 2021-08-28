package com.example.demo.dto.response;

import com.example.demo.domain.Orders;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class WorkResponse {
    private Integer id;
    private String title;
    private Double price;
}
