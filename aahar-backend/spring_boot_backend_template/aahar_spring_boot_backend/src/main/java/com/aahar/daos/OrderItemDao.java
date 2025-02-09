package com.aahar.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.pojos.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Long>{

}
