package com.aahar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.daos.MessRepository;
import com.aahar.entity.Mess;

@Service
public class MessService {
    @Autowired
    private MessRepository messRepository;
    
    public List<Mess> getMessesByLocation(Long locationId) {
        return messRepository.findByLocationId(locationId);
    }
}
