package com.aahar.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeeklyMenuReqDTO {
    private Long messId;
    private String weekday;
    private List<MenuItemReqDTO> menuItems;

}