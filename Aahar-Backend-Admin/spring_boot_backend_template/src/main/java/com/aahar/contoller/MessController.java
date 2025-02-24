package com.aahar.contoller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aahar.dtos.MessDTO;
import com.aahar.service.MessService;

@RestController
@RequestMapping("/mess")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class MessController {
    private final MessService messService;

    public MessController(MessService messService) {
        this.messService = messService;
    }

    @GetMapping
    public ResponseEntity<List<MessDTO>> getAllMesses() {
        try {
            List<MessDTO> messes = messService.getAllMesses();
            return ResponseEntity.ok(messes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMess(@PathVariable Long id) {
        messService.deleteMess(id);
        return ResponseEntity.ok("Mess deleted successfully!");
    }

}
