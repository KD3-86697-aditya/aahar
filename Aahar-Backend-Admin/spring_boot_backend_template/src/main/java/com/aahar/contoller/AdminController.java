package com.aahar.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.AdminCreateDTO;
import com.aahar.dtos.AdminLoginDTO;
import com.aahar.service.AdminService;


@RestController
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @PostMapping("/login")
    public String login(@RequestBody AdminLoginDTO loginDTO) {
        return adminService.login(loginDTO);
    }
    
    @PostMapping("/add")
    public String addAdmin(@RequestBody AdminCreateDTO adminDTO, @RequestParam String currentAdminname) {
        return adminService.addAdmin(adminDTO, currentAdminname);
    }
}



