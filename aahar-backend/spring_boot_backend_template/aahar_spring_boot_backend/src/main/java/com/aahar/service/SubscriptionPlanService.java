package com.aahar.service;

import java.util.List;

import com.aahar.dtos.SubscriptionPlanRespDTO;

public interface SubscriptionPlanService {
	 public List<SubscriptionPlanRespDTO> getSubscriptionPlansByMess(Long messId);
}
