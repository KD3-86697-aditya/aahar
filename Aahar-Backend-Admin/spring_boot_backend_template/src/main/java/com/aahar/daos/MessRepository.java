package com.aahar.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.entity.Mess;

public interface MessRepository extends JpaRepository<Mess, Long> {
    List<Mess> findByLocationId(Long locationId);
}
