package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_items") // Mapping to the OrderItems table
@Getter
@Setter
@ToString
public class OrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY) // Each order item belongs to a specific order
    @JoinColumn(name = "order_id", nullable = false) // Foreign key referencing Orders table
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY) // Each order item is associated with a specific menu item
    @JoinColumn(name = "menu_item_id", nullable = false) // Foreign key referencing MenuItems table
    private MenuItem menuItem;

    @Column(nullable = false)
    private int quantity; // Quantity of the menu item in the order
}
