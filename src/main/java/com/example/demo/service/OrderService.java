package com.example.demo.service;


import com.example.demo.dto.request.CreateOrderRequest;
import com.example.demo.dto.request.SearchOrderRequest;
import com.example.demo.dto.request.UpdateOrderRequest;
import com.example.demo.dto.response.OrderResponse;
import com.example.demo.security.UserPrincipal;

import java.util.List;

public interface OrderService {
    OrderResponse getById(Integer id);

    void deleteById(Integer id);

    void create(UserPrincipal userPrincipal, CreateOrderRequest createOrderRequest);

    List<OrderResponse> search(SearchOrderRequest searchOrderRequest);

    OrderResponse update(UserPrincipal userPrincipal, UpdateOrderRequest updateOrderRequest);


}
