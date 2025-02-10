package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlan extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mess_id", nullable = false)
    private Mess mess;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "duration", nullable = false)
    private int duration; // Duration in days

    @Column(name = "meals_per_day", nullable = false)
    private int mealsPerDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type", nullable = false)
    private MealType mealType; // Enum for meal type (breakfast, lunch, dinner, or all)
    
}
