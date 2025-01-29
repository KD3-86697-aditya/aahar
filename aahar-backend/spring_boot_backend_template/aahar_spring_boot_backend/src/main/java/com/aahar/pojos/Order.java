package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders") // Mapping to the Orders table
@Getter
@Setter
@ToString
public class Order extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY) // Each order is placed by a single user
    @JoinColumn(name = "user_id", nullable = false) // Foreign key referencing Users table
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // Each order is associated with a single mess
    @JoinColumn(name = "mess_id", nullable = false) // Foreign key referencing Messes table
    private Mess mess;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate; // Stores the date and time when the order is placed

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate; // Stores the delivery date of the order

    @Enumerated(EnumType.STRING) // Maps the enum to a string value in the database
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus = OrderStatus.PENDING; // Default value is 'PENDING'
}
