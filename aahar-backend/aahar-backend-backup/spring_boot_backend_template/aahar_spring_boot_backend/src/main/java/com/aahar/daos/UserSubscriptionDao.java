package com.aahar.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.pojos.UserSubscription;

public interface UserSubscriptionDao extends JpaRepository<UserSubscription	, Long>{

}
