package com.example.demo.mapper;


import com.example.demo.domain.Orders;
import com.example.demo.dto.request.CreateOrderRequest;
import com.example.demo.dto.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDtoToEntityMapper {
    Orders orderDtoToEntity (CreateOrderRequest createOrderRequest);
    @Mapping(target = "status", source = "orderStatus")
    OrderResponse orderEntityToDto (Orders orders);
}
