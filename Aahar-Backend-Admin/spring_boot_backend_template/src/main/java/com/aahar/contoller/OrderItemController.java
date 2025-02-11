package com.aahar.contoller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.OrderItemDTO;
import com.aahar.service.OrderItemService;

@RestController
@RequestMapping("/order-items")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItemDTO>> getItemsByOrderId(@PathVariable Long orderId) {
        try {
            List<OrderItemDTO> orderItems = orderItemService.getItemsByOrderId(orderId);
            return ResponseEntity.ok(orderItems);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
