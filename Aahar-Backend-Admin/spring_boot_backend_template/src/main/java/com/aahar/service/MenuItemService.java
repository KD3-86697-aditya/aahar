package com.aahar.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.daos.MenuItemRepository;
import com.aahar.dtos.MenuItemDTO;
import com.aahar.entity.MenuItem;


@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItemDTO> getMenuItemsByMess(Long messId) {
        List<MenuItem> menuItems = menuItemRepository.findByMessId(messId);

        if (menuItems.isEmpty()) {
            throw new RuntimeException("No menu items found for this mess ID: " + messId);
        }

        return menuItems.stream().map(menuItem -> 
            new MenuItemDTO(menuItem.getId(), 
                            menuItem.getMess().getId(),
                            menuItem.getDishName(),
                            menuItem.getPrice(),
                            menuItem.getIsAvailable(),
                            menuItem.getMealType().name())
        ).toList();
    }
}

