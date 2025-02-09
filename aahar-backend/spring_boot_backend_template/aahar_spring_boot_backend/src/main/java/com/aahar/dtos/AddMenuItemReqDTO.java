package com.aahar.dtos;

import lombok.Data;

@Data
public class AddMenuItemReqDTO {

    private MenuItemReqDTO menuItem;           // MenuItem details
    private NutritionalInfoDTO nutritionalInfo; // Nutritional Info

}