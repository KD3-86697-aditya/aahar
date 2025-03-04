package com.aahar.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}