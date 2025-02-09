package com.aahar.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aahar.dtos.SubscriptionPlanRespDTO;
import com.aahar.service.SubscriptionPlanService;

//@RestController
public class SubscriptionPlanController {

	 @Autowired
	    private SubscriptionPlanService subscriptionService;

	    @GetMapping("/mess/{messId}")
	    public ResponseEntity<List<SubscriptionPlanRespDTO>> getSubscriptionPlansByMess(@PathVariable Long messId) {
	        List<SubscriptionPlanRespDTO> plans = subscriptionService.getSubscriptionPlansByMess(messId);
	        return ResponseEntity.ok(plans);
	    }
}
