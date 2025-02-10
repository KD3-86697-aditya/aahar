package com.aahar.contoller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.OrderItemDTO;
import com.aahar.service.OrderItemService;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItemDTO> getItemsByOrderId(@PathVariable Long orderId) {
        return orderItemService.getItemsByOrderId(orderId);
    }
}
