package com.aahar.service;

import com.aahar.dtos.UserSubscriptionReqDTO;
import com.aahar.pojos.UserSubscription;

public interface UserSubscriptionService {
	public UserSubscription createUserSubscription(UserSubscriptionReqDTO userSubscriptionDto);
}