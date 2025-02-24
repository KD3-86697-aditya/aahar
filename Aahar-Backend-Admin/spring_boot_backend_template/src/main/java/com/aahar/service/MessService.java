package com.aahar.service;

import com.aahar.daos.MessRepository;
import com.aahar.dtos.MessDTO;
import com.aahar.entity.Mess;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessService {
    private final MessRepository messRepository;

    public MessService(MessRepository messRepository) {
        this.messRepository = messRepository;
    }

    public List<MessDTO> getAllMesses() {
        List<Mess> messes = messRepository.findAll();
        return messes.stream().map(mess -> new MessDTO(
                mess.getMessName(), mess.getAddress(), mess.getLocation().getId(),
                mess.getDescription(), mess.getContactNumber(), mess.getOpeningHours(),
                mess.getMessOwner().getId()
        )).collect(Collectors.toList());
    }
    
    public void deleteMess(Long messId) {
        messRepository.deleteById(messId);
    }


}
