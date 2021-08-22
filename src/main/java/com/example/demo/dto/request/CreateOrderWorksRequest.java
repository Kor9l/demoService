package com.example.demo.dto.request;

import lombok.Data;

@Data
public class CreateOrderWorksRequest {
    private Integer orderId;
    private Integer workID;
}
