package com.aahar.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aahar.pojos.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    // Find user by username or email
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    // Find mess owner by user ID (only for role 'mess_owner')
    Optional<User> findByIdAndRole(Long userId, String role);

    // Check if email or username already exists
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
