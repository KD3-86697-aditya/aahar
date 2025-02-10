package com.aahar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemReqDTO {
    private Long dishId;
    private Double price;
    private String mealType;
    private String dayOfWeek;
    private Boolean availability;

}