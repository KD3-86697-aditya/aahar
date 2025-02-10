package com.aahar.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}