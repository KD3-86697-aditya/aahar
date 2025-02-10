package com.aahar.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.MessDTO;
import com.aahar.entity.Mess;
import com.aahar.service.MessService;

@RestController
@RequestMapping("/mess")
public class MessController {
    @Autowired
    private MessService messService;
    
    @GetMapping("/by-location/{locationId}")
    public List<MessDTO> getMessesByLocation(@PathVariable Long locationId) {
        List<Mess> messes = messService.getMessesByLocation(locationId);
        
        return messes.stream().map(mess -> {
            MessDTO dto = new MessDTO();
            dto.setMessName(mess.getMessName());
            dto.setAddress(mess.getAddress());
            dto.setLocationId(mess.getLocation().getId());
            dto.setDescription(mess.getDescription());
            dto.setContactNumber(mess.getContactNumber());
            dto.setOpeningHours(mess.getOpeningHours());
            dto.setMessOwnerId(mess.getMessOwner().getId());
            return dto;
        }).toList();
    }

}
