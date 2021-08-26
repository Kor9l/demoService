package com.example.demo.controller;


import com.example.demo.dto.response.OrderResponse;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Integer id) {
        OrderResponse orderResponse = orderService.getById(id);
        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }




}