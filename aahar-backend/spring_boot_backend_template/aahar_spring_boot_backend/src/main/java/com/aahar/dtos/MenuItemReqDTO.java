package com.aahar.dtos;

import com.aahar.pojos.DayOfWeek;
import com.aahar.pojos.MealType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuItemReqDTO {
//    private Long dishId;
//    private Double price;
//    private String mealType;
//    private Boolean availability;
	
	  private Long dishId;   
	  private double price;
	    private String dayOfWeek;
	    private String mealType;

}