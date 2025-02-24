package com.aahar.contoller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aahar.dtos.StaffMembersDTO;
import com.aahar.service.StaffMembersService;



@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "http://localhost:3000")  // Allowed frontend access
public class StaffMembersController {

    @Autowired
    private StaffMembersService staffMembersService;

    
    @PostMapping
    public ResponseEntity<?> addStaffMember(@RequestBody StaffMembersDTO staffMembersDTO) {
        try {
            String result = staffMembersService.addStaffMember(staffMembersDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding staff: " + e.getMessage());
        }
    }

    
    @GetMapping
    public ResponseEntity<?> getAllStaff() {
        try {
            List<StaffMembersDTO> staffList = staffMembersService.getAllStaff().stream()
                .map(staff -> new StaffMembersDTO(
                    staff.getName(), staff.getAddress(), staff.getDob(), 
                    staff.getGender(), staff.getMobileNo(), staff.getRole()
                )).toList();
            return ResponseEntity.ok(staffList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching staff members: " + e.getMessage());
        }
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStaffMember(@PathVariable Long id) {
        try {
            String result = staffMembersService.deleteStaffMember(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting staff: " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStaffMember(@PathVariable Long id, @RequestBody StaffMembersDTO staffMembersDTO) {
        try {
            String result = staffMembersService.updateStaffMember(id, staffMembersDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating staff: " + e.getMessage());
        }
    }
}



