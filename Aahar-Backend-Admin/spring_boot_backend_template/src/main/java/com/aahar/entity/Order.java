package com.aahar.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
    
    public enum OrderStatus {
        PENDING, CONFIRMED, DELIVERED
    }
}
