package com.example.demo.dto.request;

import com.example.demo.domain.Orders;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreatePartRequest {
    private String partNumber;
    private String title;
    private Double price;
    private Set<Orders> partForOrders = new HashSet<>();
}
