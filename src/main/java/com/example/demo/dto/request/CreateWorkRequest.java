package com.example.demo.dto.request;

import com.example.demo.domain.Orders;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreateWorkRequest {

    private Integer id;
    private String title;
    private Double price;
    private Set<Orders> workForOrders = new HashSet<>();

}
