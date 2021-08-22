package com.example.demo.mapper;


import com.example.demo.domain.Order;
import com.example.demo.dto.request.CreateOrderRequest;
import com.example.demo.dto.response.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDtoToEntityMapper {
    Order orderDtoToEntity (CreateOrderRequest createOrderRequest);
    OrderResponse orderEntityToDto (Order order);
}
