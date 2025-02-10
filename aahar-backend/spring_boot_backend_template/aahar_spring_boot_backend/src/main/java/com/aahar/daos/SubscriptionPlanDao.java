package com.aahar.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.pojos.SubscriptionPlan;

public interface SubscriptionPlanDao extends JpaRepository<SubscriptionPlan, Long>{

    List<SubscriptionPlan> findByMessId(Long messId);

	
}
