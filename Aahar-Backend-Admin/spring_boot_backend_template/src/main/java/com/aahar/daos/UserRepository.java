package com.aahar.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
