package com.aahar.contoller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:3000") // Allows React to connect
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminLoginDTO loginDTO) {
        try {
            String result = adminService.login(loginDTO);

            switch (result) {
                case "Login Successful":
                    return ResponseEntity.ok(Collections.singletonMap("message", result));

                case "Admin not found":
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", result));

                case "Invalid Credentials":
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", result));

                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "Unexpected response"));
            }

        } catch (Exception e) {
            e.printStackTrace(); // Logs the error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Collections.singletonMap("error", "Server error. Please try again later."));
        }
    }


    
    @PostMapping("/add")
    public String addAdmin(@RequestBody AdminCreateDTO adminDTO, @RequestParam String currentAdminname) {
        return adminService.addAdmin(adminDTO, currentAdminname);
    }
}



