package com.aahar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemDTO {
    private Long messId;
    private String dishName;
    private Double price;
    private Boolean isAvailable;
    private String mealType;
}
