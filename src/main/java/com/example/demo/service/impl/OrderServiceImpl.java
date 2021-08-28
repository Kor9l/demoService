package com.example.demo.service.impl;


import com.example.demo.domain.Orders;
import com.example.demo.dto.request.CreateOrderRequest;
import com.example.demo.dto.request.SearchOrderRequest;
import com.example.demo.dto.request.UpdateOrderRequest;
import com.example.demo.dto.response.OrderResponse;
import com.example.demo.mapper.OrderDtoToEntityMapper;
import com.example.demo.repository.OrderRepository;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDtoToEntityMapper orderDtoToEntityMapper;

    @Override
    public OrderResponse getById(Integer id) {
        Orders orders = orderRepository.getById(id);
        return orderDtoToEntityMapper.orderEntityToDto(orders);
    }

    @Override
    public void deleteById(Integer id) { orderRepository.deleteById(id); }

    @Override
    public void create(UserPrincipal userPrincipal, CreateOrderRequest createOrderRequest) {
        Orders orders = orderDtoToEntityMapper.orderDtoToEntity(createOrderRequest);
        orders.setLastModifiedBy(userPrincipal.getId());


    }

    @Override
    public List<OrderResponse> search(SearchOrderRequest searchOrderRequest) {
        return null;
    }

    /*@Override
    public List<OrderResponse> search(SearchOrderRequest searchOrderRequest) {
        return null;
    }
*/
    @Override
    public OrderResponse update(UserPrincipal userPrincipal, UpdateOrderRequest updateOrderRequest) {
        Orders orders = orderRepository.findById(updateOrderRequest.getId())
                .orElseThrow(()-> new EntityNotFoundException("Order with id:"+updateOrderRequest.getId()+" not found."));
        orders.setClientId(updateOrderRequest.getClientId());
        orders.setOrderStatus(updateOrderRequest.getOrderStatus());
        orders.setTechnicId(updateOrderRequest.getTechnicId());
        orders.setLastModifiedBy(userPrincipal.getId());
        orderRepository.save(orders);

        return orderDtoToEntityMapper.orderEntityToDto(orders);
    }
}
