package com.aahar.service;

import com.aahar.daos.MessDao;
import com.aahar.daos.SubscriptionPlanDao;
import com.aahar.dtos.SubscriptionPlanReqDTO;
import com.aahar.dtos.SubscriptionPlanRespDTO;
import com.aahar.pojos.Mess;
import com.aahar.pojos.SubscriptionPlan;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanDao subscriptionPlanDao;

    @Autowired
    private MessDao messDao;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<SubscriptionPlanRespDTO> getSubscriptionPlansByMess(Long messId) {
        List<SubscriptionPlan> subsList = subscriptionPlanDao.findByMessId(messId);
        return subsList.stream().map(plan -> mapper.map(plan, SubscriptionPlanRespDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionPlanRespDTO addSubscriptionPlan(Long messId, SubscriptionPlanReqDTO request) {
        Mess mess = messDao.findById(messId).orElseThrow(() -> new RuntimeException("Mess not found"));
        SubscriptionPlan plan = new SubscriptionPlan();
        plan.setMess(mess);
        plan.setName(request.getName());
        plan.setPrice(request.getPrice());
        plan.setDuration(request.getDuration());
        plan.setMealsPerDay(request.getMealsPerDay());
        plan.setMealType(request.getMealType());

        SubscriptionPlan savedPlan = subscriptionPlanDao.save(plan);
        return mapper.map(savedPlan, SubscriptionPlanRespDTO.class);
    }

    @Override
    public SubscriptionPlanRespDTO updateSubscriptionPlan(Long planId, SubscriptionPlanReqDTO request) {
        SubscriptionPlan plan = subscriptionPlanDao.findById(planId)
                .orElseThrow(() -> new RuntimeException("Subscription plan not found"));

        plan.setName(request.getName());
        plan.setPrice(request.getPrice());
        plan.setDuration(request.getDuration());
        plan.setMealsPerDay(request.getMealsPerDay());
        plan.setMealType(request.getMealType());

        SubscriptionPlan updatedPlan = subscriptionPlanDao.save(plan);
        return mapper.map(updatedPlan, SubscriptionPlanRespDTO.class);
    }

    @Override
    public String deleteSubscriptionPlan(Long planId) {
        if (!subscriptionPlanDao.existsById(planId)) {
            throw new RuntimeException("Subscription plan not found");
        }
        subscriptionPlanDao.deleteById(planId);
        return "Subscription plan deleted successfully";
    }
}
