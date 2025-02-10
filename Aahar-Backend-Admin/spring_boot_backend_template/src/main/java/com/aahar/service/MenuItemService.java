package com.aahar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.daos.MenuItemRepository;
import com.aahar.entity.MenuItem;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    public List<MenuItem> getMenuItemsByMess(Long messId) {
        return menuItemRepository.findByMessId(messId);
    }
}
