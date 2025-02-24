package com.aahar.daos;

import com.aahar.entity.Mess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessRepository extends JpaRepository<Mess, Long> {
    // No extra query needed, findAll() is built-in
}
