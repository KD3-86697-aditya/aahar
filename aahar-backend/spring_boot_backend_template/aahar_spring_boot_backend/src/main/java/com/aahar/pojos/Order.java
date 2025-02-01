package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
