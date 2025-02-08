package com.aahar.service;

import java.util.Optional;

import com.aahar.pojos.User;

public interface UserService {

    // Built-in JPA methods wrapped in explicit service methods for clarity
    User addUser(User user);   // ✅ Wrapper for save()
    Optional<User> findUserById(Long id); // ✅ Wrapper for findById()
    void deleteUser(Long id);  // ✅ Wrapper for deleteById()

    // Custom methods for user retrieval and validation
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findMessOwnerById(Long userId);
}
