package com.aahar.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.aahar.entity.Order.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Long userId;
    private Long messId;
    private LocalDateTime orderPlacedAt;
    private LocalDateTime deliveryDeliveredAt;
    private OrderStatus orderStatus;
    private List<OrderItemDTO> orderedItems;
}
