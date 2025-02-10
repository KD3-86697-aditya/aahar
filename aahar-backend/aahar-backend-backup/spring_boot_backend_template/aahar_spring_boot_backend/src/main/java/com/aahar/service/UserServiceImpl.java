package com.aahar.service;

import com.aahar.daos.LocationDao;
import com.aahar.daos.UserDao;
import com.aahar.dtos.PasswordUpdateDto;
import com.aahar.dtos.UpdateUserProfileDto;
import com.aahar.pojos.Location;
import com.aahar.pojos.User;
import com.aahar.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private LocationDao locationsDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

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

    
    
	@Override
	public String updateUserProfile(UpdateUserProfileDto profileDto, String email) {
		User user = userDao.findByEmail(email).orElseThrow(() -> new RuntimeException("Uer Not Found"));

		user.setUsername(profileDto.getUsername());
		user.setPhoneNumber(profileDto.getPhoneNumber());

		Location location = locationsDao.findById(user.getLocation().getId())
				.orElseThrow(() -> new RuntimeException("Location not Found"));
		location.setCity(profileDto.getCity());
		location.setState(profileDto.getState());
		location.setPincode(profileDto.getPincode());

		locationsDao.save(location);
		user.getLocation().setId(location.getId());
		userDao.save(user);
		return "User details updated successfully";
	}

	@Override
	public String updateUserPassword(PasswordUpdateDto passwordDto, String email) {
		User user = userDao.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		if (!passwordEncoder.matches(passwordDto.getOldPassword(), user.getPasswordHash())) {
			throw new RuntimeException("Incorrect old password");
		}

		String encodedPassword = passwordEncoder.encode(passwordDto.getNewPassword());
		user.setPasswordHash(encodedPassword);

		userDao.save(user);
		return "Password Updated Successfully";
	}

	
}
