package com.aahar.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSubscriptionReqDTO {
    private Long userId; // ID of the user
    private Long messId; // ID of the mess
    private Long planId; // ID of the subscription plan
    private LocalDate startDate;
    private LocalDate endDate;
}