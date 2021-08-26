package com.example.demo.dto.response;


import com.example.demo.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponse {
    private Integer id;
    private Integer technicId;
    private Integer clientId;
    private OrderStatus status;
    private Integer lastModifiedBy;
}
