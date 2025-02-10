package com.aahar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aahar.daos.OrderRepository;
import com.aahar.dtos.OrderDTO;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> new OrderDTO(order.getId(), order.getOrderPlacedAt(), order.getOrderStatus())).collect(Collectors.toList());
    }
}
