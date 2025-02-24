package com.aahar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aahar.daos.OrderItemRepository;
import com.aahar.dtos.OrderItemDTO;
import com.aahar.entity.OrderItem;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItemDTO> getItemsByOrderId(Long orderId) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);
        return orderItems.stream().map(orderItem -> {
            OrderItemDTO dto = new OrderItemDTO();
            dto.setId(orderItem.getId());
            dto.setOrderId(orderItem.getOrder().getId());
            dto.setMenuItemId(orderItem.getMenuItem().getId());
            dto.setQuantity(orderItem.getQuantity());
            return dto;
        }).collect(Collectors.toList());
    }
}
