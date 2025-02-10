package com.aahar.controllers;

import com.aahar.dtos.SubscriptionPlanReqDTO;
import com.aahar.dtos.SubscriptionPlanRespDTO;
import com.aahar.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription-plans")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @GetMapping("/{messId}")
    public ResponseEntity<List<SubscriptionPlanRespDTO>> getPlansByMess(@PathVariable Long messId) {
        return ResponseEntity.ok(subscriptionPlanService.getSubscriptionPlansByMess(messId));
    }

    @PostMapping("/{messId}/add")
    public ResponseEntity<SubscriptionPlanRespDTO> addSubscriptionPlan(
            @PathVariable Long messId, @RequestBody SubscriptionPlanReqDTO request) {
        return ResponseEntity.ok(subscriptionPlanService.addSubscriptionPlan(messId, request));
    }

    @PutMapping("/{planId}/update")
    public ResponseEntity<SubscriptionPlanRespDTO> updateSubscriptionPlan(
            @PathVariable Long planId, @RequestBody SubscriptionPlanReqDTO request) {
        return ResponseEntity.ok(subscriptionPlanService.updateSubscriptionPlan(planId, request));
    }

    @DeleteMapping("/{planId}/delete")
    public ResponseEntity<String> deleteSubscriptionPlan(@PathVariable Long planId) {
        return ResponseEntity.ok(subscriptionPlanService.deleteSubscriptionPlan(planId));
    }
}
