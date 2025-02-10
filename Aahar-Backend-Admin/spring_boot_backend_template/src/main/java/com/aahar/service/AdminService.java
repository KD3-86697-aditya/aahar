package com.aahar.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.aahar.daos.AdminRepository;
import com.aahar.dtos.AdminCreateDTO;
import com.aahar.dtos.AdminLoginDTO;
import com.aahar.entity.Admin;
import com.aahar.exception.AdminNotFoundException;


@Service
public class AdminService {
	@Autowired
    private AdminRepository adminRepository;
    
    
    public String login(AdminLoginDTO loginDTO) {
    	Admin admin = adminRepository.findByAdminname(loginDTO.getAdminname())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found"));
            
            if (!loginDTO.getPassword().equals(admin.getPassword())) {
                throw new AdminNotFoundException("Invalid credentials");
            }
            
            return "Login successful";
    }
    
    public String addAdmin(AdminCreateDTO adminDTO, String currentAdminname) {
        if (!adminRepository.existsByAdminname(currentAdminname)) {
            throw new AdminNotFoundException("Only existing admins can add new admins");
        }
        
        Admin newAdmin = new Admin();
        newAdmin.setAdminname(adminDTO.getAdminname());
        newAdmin.setPassword(adminDTO.getPassword());
        newAdmin.setEmail(adminDTO.getEmail());
        newAdmin.setFirstName(adminDTO.getFirstName());
        newAdmin.setLastName(adminDTO.getLastName());
        newAdmin.setPhoneNumber(adminDTO.getPhoneNumber());
        
        adminRepository.save(newAdmin);
        return "New admin added successfully";
    }
}
