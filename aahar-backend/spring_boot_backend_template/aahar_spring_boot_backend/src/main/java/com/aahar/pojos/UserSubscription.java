package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "user_subscriptions") // Mapping to the UserSubscriptions table
@Getter
@Setter
@ToString
public class UserSubscription extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY) // Many subscriptions can belong to one user
    @JoinColumn(name = "user_id", nullable = false) // Foreign key referencing Users table
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // Many subscriptions can belong to one mess
    @JoinColumn(name = "mess_id", nullable = false) // Foreign key referencing Messes table
    private Mess mess;

    @ManyToOne(fetch = FetchType.LAZY) // Many subscriptions can belong to one subscription plan
    @JoinColumn(name = "plan_id", nullable = false) // Foreign key referencing SubscriptionPlans table
    private SubscriptionPlan subscriptionPlan;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate; // Subscription start date

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate; // Subscription end date
}

