package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchOrderRequest {
    private Integer Id;
    private Integer clientId;
}
