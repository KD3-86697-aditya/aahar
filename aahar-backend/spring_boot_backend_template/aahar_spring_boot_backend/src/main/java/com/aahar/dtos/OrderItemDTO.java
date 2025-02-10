package com.aahar.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {
    private Long menuItemId;
    private String dishName;
    private int quantity;
    private double price; // Add price here

    // Constructor
    public OrderItemDTO(Long menuItemId, String dishName, int quantity, double price) {
        this.menuItemId = menuItemId;
        this.dishName = dishName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters & Setters
}
