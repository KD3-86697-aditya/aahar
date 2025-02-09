package com.aahar.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.custom_exceptions.ResourceNotFoundException;
import com.aahar.daos.MessDao;
import com.aahar.daos.SubscriptionPlanDao;
import com.aahar.daos.UserDao;
import com.aahar.daos.UserSubscriptionDao;
import com.aahar.dtos.UserSubscriptionReqDTO;
import com.aahar.pojos.Mess;
import com.aahar.pojos.SubscriptionPlan;
import com.aahar.pojos.User;
import com.aahar.pojos.UserSubscription;

@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {
	
	 @Autowired
	    private UserSubscriptionDao userSubscriptionDao;

	    @Autowired
	    private UserDao userDao;

	    @Autowired
	    private MessDao messRepository;

	    @Autowired
	    private SubscriptionPlanDao subscriptionPlanDao;

	    @Autowired
	    private ModelMapper modelMapper;

	    public UserSubscription createUserSubscription(UserSubscriptionReqDTO userSubscriptionDto) {
	        User user = userDao.findById(userSubscriptionDto.getUserId())
	                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	        Mess mess = messRepository.findById(userSubscriptionDto.getMessId())
	                .orElseThrow(() -> new ResourceNotFoundException("Mess not found"));
	        SubscriptionPlan subscriptionPlan = subscriptionPlanDao.findById(userSubscriptionDto.getPlanId())
	                .orElseThrow(() -> new ResourceNotFoundException("Subscription plan not found"));

	        // Map DTO to Entity
	        UserSubscription userSubscription = modelMapper.map(userSubscriptionDto, UserSubscription.class);

	        // Set the relationships manually
	        userSubscription.setUser(user);
	        userSubscription.setMess(mess);
	        userSubscription.setSubscriptionPlan(subscriptionPlan);

	        // Save the UserSubscription
	        return userSubscriptionDao.save(userSubscription);
	    }

}
