package com.aahar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private Long id;
    private Long orderId;
    private Long menuItemId;
    private int quantity;
}
