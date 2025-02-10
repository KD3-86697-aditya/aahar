package com.aahar.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByMessId(Long messId);
}
