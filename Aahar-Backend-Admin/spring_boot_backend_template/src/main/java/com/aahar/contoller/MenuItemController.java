package com.aahar.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.MenuItemDTO;
import com.aahar.entity.MenuItem;
import com.aahar.service.MenuItemService;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;
    
    @GetMapping("/by-mess/{messId}")
    public List<MenuItemDTO> getMenuItemsByMess(@PathVariable Long messId) {
        List<MenuItem> menuItems = menuItemService.getMenuItemsByMess(messId);

        return menuItems.stream().map(menuItem -> {
            MenuItemDTO dto = new MenuItemDTO();
            dto.setMessId(menuItem.getMess().getId());
            dto.setDishName(menuItem.getDishName());
            dto.setPrice(menuItem.getPrice());
            dto.setIsAvailable(menuItem.getIsAvailable());
            dto.setMealType(menuItem.getMealType().name());
            return dto;
        }).toList();
    }

}
