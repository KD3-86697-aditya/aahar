package com.aahar.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aahar.pojos.MenuItem;

@Repository
public interface MenuItemDao extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByMessId(Long messId);
}	
