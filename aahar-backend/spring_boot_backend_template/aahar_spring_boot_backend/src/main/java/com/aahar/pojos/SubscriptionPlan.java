package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "subscription_plans") // Mapping to the SubscriptionPlans table
@Getter
@Setter
@ToString
public class SubscriptionPlan extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY) // Many SubscriptionPlans can belong to one Mess
    @JoinColumn(name = "mess_id", nullable = false) // Foreign key referencing Messes table
    private Mess mess;

    @Column(name = "name", nullable = false, length = 255)
    private String name; // Name of the subscription plan

    @Column(name = "price", nullable = false, precision = 10)
    private double price; // Price of the subscription plan

    @Column(name = "duration", nullable = false)
    private int duration; // Duration of the plan in days

    @Column(name = "meals_per_day", nullable = false)
    private int mealsPerDay; // Number of meals provided per day
}
