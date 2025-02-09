package com.aahar.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.pojos.Order;

public interface OrderDao extends JpaRepository<Order,Long> {

}
