package com.aahar.dtos;


import java.time.LocalDateTime;
import java.util.List;

import com.aahar.entity.Order.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId;
    private Long messId;
    private LocalDateTime orderPlacedAt;
    private LocalDateTime deliveryDeliveredAt;
    private OrderStatus orderStatus;
    private List<OrderItemDTO> orderItems;
    
    public OrderDTO(Long id, LocalDateTime orderPlacedAt, OrderStatus orderStatus) {
        this.id = id;
        this.orderPlacedAt = orderPlacedAt;
        this.orderStatus = orderStatus;
    }
}
