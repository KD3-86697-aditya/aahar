package com.aahar.service;
import com.aahar.daos.MenuItemDao;
import com.aahar.daos.MessDao;
import com.aahar.daos.OrderDao;
import com.aahar.daos.OrderItemDao;
import com.aahar.daos.UserDao;
import com.aahar.dtos.OrderResponseDTO;
import com.aahar.dtos.PlaceOrderRequestDTO;
import com.aahar.dtos.OrderItemDTO;
import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.LocationDTO;
import com.aahar.pojos.Order;
import com.aahar.pojos.OrderItem;
import com.aahar.pojos.OrderStatus;
import com.aahar.pojos.User;

import jakarta.transaction.Transactional;

import com.aahar.pojos.Location;
import com.aahar.pojos.Mess;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.MenuItem;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ModelMapper modelMapper;

	@Autowired
	private MessDao messDao;

	@Autowired
	private MenuItemDao menuItemDao;
	
	@Autowired
	private OrderItemDao orderItemDao;

	@Autowired
	private UserDao userDao;

    @Override
    public List<OrderResponseDTO> getAllOrdersForMessOwner(Long messOwnerId) {
        List<Order> orders = orderDao.findAllOrdersByMessOwnerId(messOwnerId);

        return orders.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDTO> getRecentOrdersForMessOwner(Long messOwnerId) {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);

        List<Order> orders = orderDao.findRecentOrdersByMessOwner(messOwnerId, sevenDaysAgo);

        return orders.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private OrderResponseDTO convertToDto(Order order) {
        // ✅ Convert User Location to LocationDTO
        LocationDTO locationDTO = convertLocationToDto(order.getUser().getLocation());

        return new OrderResponseDTO(
                order.getId(),
                order.getUser().getId(),
                order.getUser().getUsername(),
                order.getOrderPlacedAt(),
                order.getOrderStatus(), // ✅ Now using Enum type directly
                order.getOrderItems().stream()
                        .map(this::convertOrderItemToDto)
                        .collect(Collectors.toList()),
                locationDTO // ✅ Include location details
        );
    }

    private OrderItemDTO convertOrderItemToDto(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getMenuItem().getId(),
                orderItem.getMenuItem().getDish().getName(),
                orderItem.getQuantity(),
                orderItem.getMenuItem().getPrice()
        );
    }

    private LocationDTO convertLocationToDto(Location location) {
        if (location == null) return null;
        return new LocationDTO(location.getId(), location.getCity(), location.getState(), location.getPincode());
    }

    @Override
    public OrderResponseDTO getOrderById(Long orderId) {
        return orderDao.findById(orderId)
                .map(order -> {
                    // ✅ Convert User Location to LocationDTO
                    LocationDTO locationDTO = convertLocationToDto(order.getUser().getLocation());

                    return new OrderResponseDTO(
                            order.getId(),
                            order.getUser().getId(),
                            order.getUser().getUsername(),
                            order.getOrderPlacedAt(),
                            order.getOrderStatus(), // ✅ Use Enum type here
                            order.getOrderItems().stream()
                                    .map(this::convertOrderItemToDto)
                                    .collect(Collectors.toList()),
                            locationDTO // ✅ Include location details
                    );
                })
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatus newStatus) {
        Order order = orderDao.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        order.setOrderStatus(newStatus); // ✅ Update enum type directly
        orderDao.save(order);
    }

    
	@Override
	public ApiResponse placeOrder(PlaceOrderRequestDTO request) {
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
		order.setOrderStatus(OrderStatus.PENDING);

		orderDao.save(order);

		// Create Order Items
		List<OrderItem> orderItems = request.getItems().stream().map(item -> {
			com.aahar.pojos.MenuItem menuItem = menuItemDao.findById(item.getMenuItemId())
					.orElseThrow(() -> new IllegalArgumentException("Invalid menu item ID"));

			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setMenuItem(null);
			orderItem.setQuantity(item.getQuantity());

			return orderItem;
		}).collect(Collectors.toList());

		orderItemDao.saveAll(orderItems);

		return new ApiResponse("Order placed successfully with ID: " + order.getId());
	}
}
