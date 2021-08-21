package com.example.demo.dto.request.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateOrderRequest extends CreateOrderRequest{
    private Integer id;
}
