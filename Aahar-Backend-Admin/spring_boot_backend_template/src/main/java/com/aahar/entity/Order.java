package com.aahar.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Admin user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mess_id", nullable = false)
    private Mess mess;
    
    @Column(name = "order_placed_at", nullable = false)
    private LocalDateTime orderPlacedAt;
    
    @Column(name = "delivery_delivered_at")
    private LocalDateTime deliveryDeliveredAt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    public enum OrderStatus {
        PENDING, CONFIRMED, DELIVERED
    }
}
