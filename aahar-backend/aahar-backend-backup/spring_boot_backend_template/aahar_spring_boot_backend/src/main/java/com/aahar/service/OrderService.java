package com.aahar.service;

import java.util.List;

import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.OrderResponseDTO;
import com.aahar.dtos.PlaceOrderRequestDTO;
import com.aahar.pojos.OrderStatus;

public interface OrderService {
    public List<OrderResponseDTO> getAllOrdersForMessOwner(Long messOwnerId);
    
    public List<OrderResponseDTO> getRecentOrdersForMessOwner(Long messOwnerId);

    public OrderResponseDTO getOrderById(Long orderId);
    
    public void updateOrderStatus(Long orderId, OrderStatus newStatus);

	public ApiResponse placeOrder(PlaceOrderRequestDTO request);


}
