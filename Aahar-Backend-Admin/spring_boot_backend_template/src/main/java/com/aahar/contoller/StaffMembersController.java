package com.aahar.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.StaffMembersDTO;
import com.aahar.service.StaffMembersService;

@RestController
@RequestMapping("/staff")
public class StaffMembersController {
    @Autowired
    private StaffMembersService staffMembersService;
    
    @PostMapping("/add")
    public String addStaffMember(@RequestBody StaffMembersDTO staffMembersDTO) {
        return staffMembersService.addStaffMember(staffMembersDTO);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteStaffMember(@PathVariable Long id) {
        return staffMembersService.deleteStaffMember(id);
    }
    
    @GetMapping("/all")
    public List<StaffMembersDTO> getAllStaff() {
        return staffMembersService.getAllStaff().stream()
            .map(staff -> new StaffMembersDTO(
                staff.getName(), staff.getAddress(), staff.getDob(), 
                staff.getGender(), staff.getMobileNo(), staff.getRole()
            )).toList();
    }
    
    @PutMapping("/update/{id}")
    public String updateStaffMember(@PathVariable Long id, @RequestBody StaffMembersDTO staffMembersDTO) {
        return staffMembersService.updateStaffMember(id, staffMembersDTO);
    }
}

