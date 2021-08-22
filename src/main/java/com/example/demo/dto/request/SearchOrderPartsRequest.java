package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchOrderPartsRequest {
    private Integer orderId;
}
