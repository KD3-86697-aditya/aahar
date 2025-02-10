package com.aahar.service;

import com.aahar.dtos.SubscriptionPlanReqDTO;
import com.aahar.dtos.SubscriptionPlanRespDTO;
import java.util.List;

public interface SubscriptionPlanService {
    List<SubscriptionPlanRespDTO> getSubscriptionPlansByMess(Long messId);
    SubscriptionPlanRespDTO addSubscriptionPlan(Long messId, SubscriptionPlanReqDTO request);
    SubscriptionPlanRespDTO updateSubscriptionPlan(Long planId, SubscriptionPlanReqDTO request);
    String deleteSubscriptionPlan(Long planId);
}
