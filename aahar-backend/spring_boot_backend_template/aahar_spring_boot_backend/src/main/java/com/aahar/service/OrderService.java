package com.aahar.service;

import com.aahar.dtos.PlaceOrderRequestDTO;

public interface OrderService {
	public String placeOrder(PlaceOrderRequestDTO request);
}
