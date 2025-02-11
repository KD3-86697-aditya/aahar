package com.aahar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aahar.daos.OrderRepository;
import com.aahar.dtos.OrderDTO;
import com.aahar.dtos.OrderItemDTO;
import com.aahar.entity.Order;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long orderId) {
        return orderRepository.findById(orderId).map(this::convertToDTO).orElse(null);
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setMessId(order.getMess().getId());
        dto.setOrderPlacedAt(order.getOrderPlacedAt());
        dto.setDeliveryDeliveredAt(order.getDeliveryDeliveredAt());
        dto.setOrderStatus(order.getOrderStatus());

        // Convert order items
        dto.setOrderedItems(order.getOrderItems().stream().map(item -> {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setOrderId(order.getId());
            itemDTO.setMenuItemId(item.getMenuItem().getId());
            itemDTO.setQuantity(item.getQuantity());
            return itemDTO;
        }).collect(Collectors.toList()));

        return dto;
    }
}
