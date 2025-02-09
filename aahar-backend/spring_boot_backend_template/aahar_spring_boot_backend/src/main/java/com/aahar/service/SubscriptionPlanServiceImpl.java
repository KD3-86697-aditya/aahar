package com.aahar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.daos.SubscriptionPlanDao;
import com.aahar.dtos.SubscriptionPlanRespDTO;
import com.aahar.pojos.SubscriptionPlan;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

	@Autowired
	private SubscriptionPlanDao subscriptionPlanDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<SubscriptionPlanRespDTO> getSubscriptionPlansByMess(Long messId) {
		List<SubscriptionPlan> subsList = subscriptionPlanDao.findByMessId(messId);
		return subsList.stream().map(plans -> mapper.map(plans, SubscriptionPlanRespDTO.class))
				.collect(Collectors.toList());
	}

}
