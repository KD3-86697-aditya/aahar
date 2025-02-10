package com.aahar.controllers;

import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.OrderResponseDTO;
import com.aahar.dtos.PlaceOrderRequestDTO;
import com.aahar.pojos.OrderStatus;
import com.aahar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ✅ Get all orders for a mess owner
    @GetMapping("/mess/{messOwnerId}")
    public List<OrderResponseDTO> getAllOrdersForMessOwner(@PathVariable Long messOwnerId) {
        return orderService.getAllOrdersForMessOwner(messOwnerId);
    }

    // ✅ Get recent orders (last 7 days) with PENDING orders prioritized
    @GetMapping("/mess/{messOwnerId}/recent")
    public List<OrderResponseDTO> getRecentOrdersForMessOwner(@PathVariable Long messOwnerId) {
        return orderService.getRecentOrdersForMessOwner(messOwnerId);
    }
    
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
    
    @PutMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok("Order status updated to " + status);
    }
    
    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@RequestBody PlaceOrderRequestDTO request) {
        try {
            ApiResponse response = orderService.placeOrder(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid order request: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An unexpected error occurred: " + e.getMessage());
        }
    }

}
