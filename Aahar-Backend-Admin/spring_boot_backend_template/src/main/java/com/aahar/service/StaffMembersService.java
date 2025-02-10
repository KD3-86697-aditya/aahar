package com.aahar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.daos.StaffMembersRepository;
import com.aahar.dtos.StaffMembersDTO;
import com.aahar.entity.StaffMembers;

@Service
public class StaffMembersService {
	
	@Autowired
    private StaffMembersRepository staffMembersRepository;
    
    public String addStaffMember(StaffMembersDTO staffMembersDTO) {
        StaffMembers staffMember = new StaffMembers();
        staffMember.setName(staffMembersDTO.getName());
        staffMember.setAddress(staffMembersDTO.getAddress());
        staffMember.setDob(staffMembersDTO.getDob());
        staffMember.setGender(staffMembersDTO.getGender());
        staffMember.setMobileNo(staffMembersDTO.getMobileNo());
        staffMember.setRole(staffMembersDTO.getRole());
        
        staffMembersRepository.save(staffMember);
        return "Staff member added successfully";
    }
	
    public String deleteStaffMember(Long id) {
        staffMembersRepository.deleteById(id);
        return "Staff member deleted successfully";
    }
    
    public List<StaffMembers> getAllStaff() {
        return staffMembersRepository.findAll();
    }
    
    public String updateStaffMember(Long id, StaffMembersDTO staffMembersDTO) {
        StaffMembers staffMember = staffMembersRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Staff member not found"));
        
        staffMember.setName(staffMembersDTO.getName());
        staffMember.setAddress(staffMembersDTO.getAddress());
        staffMember.setDob(staffMembersDTO.getDob());
        staffMember.setGender(staffMembersDTO.getGender());
        staffMember.setMobileNo(staffMembersDTO.getMobileNo());
        staffMember.setRole(staffMembersDTO.getRole());
        
        staffMembersRepository.save(staffMember);
        return "Staff member updated successfully";
    }
	
}
