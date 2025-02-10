package com.aahar.dtos;

import java.util.List;

import lombok.Data;

@Data
public class PlaceOrderRequestDTO {
    private Long userId;
    private Long messId;
    private List<OrderItemDTO> items;

    @Data
    public static class OrderItemDTO {
        private Long menuItemId;
        private int quantity;
    }
}