package com.aahar.dtos;

import com.aahar.pojos.MealType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionPlanReqDTO {
    private String name;
    private double price;
    private int duration;
    private int mealsPerDay;
    private MealType mealType;
}
