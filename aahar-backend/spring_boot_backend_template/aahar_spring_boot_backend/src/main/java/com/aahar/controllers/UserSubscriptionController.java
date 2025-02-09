package com.aahar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.UserSubscriptionReqDTO;
import com.aahar.pojos.UserSubscription;
import com.aahar.service.UserSubscriptionService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/user-subscriptions")
public class UserSubscriptionController {

    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @PostMapping
    public ResponseEntity<?> createUserSubscription(@RequestBody UserSubscriptionReqDTO userSubscriptionDto) {
        try {
            UserSubscription createdSubscription = userSubscriptionService.createUserSubscription(userSubscriptionDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscription);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Resource not found: " + e.getMessage()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid request data: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("An error occurred: " + e.getMessage()));
        }
    }
}
