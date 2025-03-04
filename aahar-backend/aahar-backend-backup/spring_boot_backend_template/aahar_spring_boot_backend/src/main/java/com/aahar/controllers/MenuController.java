package com.aahar.controllers;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.MenuItemRespDTO;
import com.aahar.dtos.MenuItemUpdateRequest;
import com.aahar.pojos.MenuItem;
import com.aahar.pojos.MenuItem.MealType;
import com.aahar.pojos.WeeklyMenu;
import com.aahar.service.MenuServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/menu")
@Validated
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class MenuController {

	@Autowired
    private  MenuServiceImpl menuService;
    
    public MenuController()
    {
		System.out.println("Inside  constructor " + getClass());
    }

    @GetMapping("/weekly/{messOwnerId}")
    public ResponseEntity<List<MenuItemRespDTO>> getWeeklyMenu(@PathVariable Long messOwnerId) {
        List<MenuItemRespDTO> menuItems = menuService.getWeeklyMenu(messOwnerId);
        System.out.println("this is the query result  this is menu  controller speaking ");
        
        menuItems.forEach(System.out::println);
        return ResponseEntity.ok(menuItems);
        
    }

 // Add a new menu item
    @PostMapping("/add")
    public ResponseEntity<?> addMenuItem(
            @RequestParam Long messOwnerId,
            @RequestParam String dishName,
            @RequestParam double price,
            @RequestParam com.aahar.pojos.WeeklyMenu.DayOfWeek dayOfWeek,  // Change this
            @RequestParam MealType mealType) {

        MenuItemRespDTO menuItemDto = menuService.addMenuItem(messOwnerId, dishName, price, dayOfWeek, mealType);
        return ResponseEntity.ok(menuItemDto);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateMenuItem(@RequestBody MenuItemUpdateRequest updateRequest) {
        try {
            menuService.updateMenuItem(updateRequest);
            return ResponseEntity.ok("Menu item updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating menu item.");
        }
    }

    @DeleteMapping("/delete/{menuItemId}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long menuItemId) {
        try {
            boolean deleted = menuService.deleteMenuItem(menuItemId);
            if (deleted) {
                return ResponseEntity.ok("Menu item deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Menu item not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting menu item: " + e.getMessage());
        }
    }
     
//    @PutMapping("/update/{menuItemId}")
//    public ResponseEntity<?> updateMenuItem(
//            @PathVariable Long menuItemId,
//            @RequestParam String dishName,
//            @RequestParam double price,
//            @RequestParam com.aahar.pojos.WeeklyMenu.DayOfWeek dayOfWeek,
//            @RequestParam MealType mealType) {
//
//        MenuItemRespDTO updatedMenuItem = menuService.updateMenuItem(menuItemId, dishName, price, dayOfWeek, mealType);
//        return ResponseEntity.ok(updatedMenuItem);
//    }
}
