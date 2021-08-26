package com.example.demo.mapper;


import com.example.demo.domain.Orders;
import com.example.demo.dto.request.CreateOrderRequest;
import com.example.demo.dto.response.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDtoToEntityMapper {
    Orders orderDtoToEntity (CreateOrderRequest createOrderRequest);
    OrderResponse orderEntityToDto (Orders orders);
}
