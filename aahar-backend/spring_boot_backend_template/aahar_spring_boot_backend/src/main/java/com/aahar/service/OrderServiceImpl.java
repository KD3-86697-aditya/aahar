
package com.aahar.service;

import com.aahar.daos.MenuItemDao;
import com.aahar.daos.MessDao;
import com.aahar.daos.OrderDao;
import com.aahar.daos.OrderItemDao;
import com.aahar.daos.UserDao;
import com.aahar.dtos.PlaceOrderRequestDTO;
import com.aahar.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private MessDao messDao;

	@Autowired
	private MenuItemDao menuItemDao;

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderItemDao orderItemDao;

	public String placeOrder(PlaceOrderRequestDTO request) {
		// Validate User
		User user = userDao.findById(request.getUserId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

		// Validate Mess
		Mess mess = messDao.findById(request.getMessId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid mess ID"));

		// Create Order
		Order order = new Order();
		order.setUser(user);
		order.setMess(mess);
		order.setOrderPlacedAt(LocalDateTime.now());
		order.setOrderStatus(Order.OrderStatus.PENDING);

		orderDao.save(order);

		// Create Order Items
		List<OrderItem> orderItems = request.getItems().stream().map(item -> {
			MenuItem menuItem = menuItemDao.findById(item.getMenuItemId())
					.orElseThrow(() -> new IllegalArgumentException("Invalid menu item ID"));

			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setMenuItem(menuItem);
			orderItem.setQuantity(item.getQuantity());

			return orderItem;
		}).collect(Collectors.toList());

		orderItemDao.saveAll(orderItems);

		return "Order placed successfully with ID: " + order.getId();
	}
}
