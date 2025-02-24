package com.aahar.contoller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aahar.dtos.MenuItemDTO;
import com.aahar.service.MenuItemService;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuItemController {
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/by-mess/{messId}")
    public ResponseEntity<?> getMenuItemsByMess(@PathVariable Long messId) {
        try {
            List<MenuItemDTO> menuItems = menuItemService.getMenuItemsByMess(messId);
            return ResponseEntity.ok(menuItems);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An unexpected error occurred.");
        }
    }

}
