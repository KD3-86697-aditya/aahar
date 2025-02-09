package com.aahar.service;

import com.aahar.daos.UserDao;
import com.aahar.pojos.User;
import com.aahar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //  Explicit method to add a user (mess owner, admin, etc.)
    @Override
    public User addUser(User user) {
        return userDao.save(user); // ✅ Internally calls JPA's save()
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userDao.findById(id); // ✅ Wrapper for findById()
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id); // ✅ Wrapper for deleteById()
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userDao.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userDao.existsByEmail(email);
    }

    @Override
    public Optional<User> findMessOwnerById(Long userId) {
        return userDao.findByIdAndRole(userId, "mess_owner");
    }

	
}
