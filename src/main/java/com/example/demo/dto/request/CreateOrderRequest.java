package com.example.demo.dto.request;


import com.example.demo.enums.OrderStatus;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private Integer technicId;
    private Integer clientId;
    private OrderStatus orderStatus;
    private Long lastModifiedBy;
}
