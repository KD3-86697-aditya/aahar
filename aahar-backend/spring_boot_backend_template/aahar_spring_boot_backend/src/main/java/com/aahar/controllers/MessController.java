package com.aahar.controllers;


import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.MessReqDTO;
import com.aahar.service.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messes")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class MessController {

    // Dependency injection
    @Autowired
    private MessService messService;

    // Constructor for logging (optional)
    public MessController() {
        System.out.println("in ctor " + getClass());
    }

   
    @GetMapping
    public ResponseEntity<?> getAllMesses()
    {
    try {
		
    	return ResponseEntity.status(HttpStatus.OK).body(messService.getAllMesses());
    
	} catch (Exception e) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));	
	}
    }
    
    @PostMapping
    public ResponseEntity<?> addNewMess(@RequestBody MessReqDTO messDTO) {
        System.out.println("in add mess " + messDTO);
        
        try {
        	return ResponseEntity.status(HttpStatus.CREATED).body(messService.addMess(messDTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));	
		}  
    }
    
    @PutMapping("/{messId}")
    public ResponseEntity<?> updateMess(@PathVariable Long messId, @RequestBody MessReqDTO messDTO) {
        
        System.out.println("Updating mess with ID: " + messId);
        
        try {
        	ApiResponse response = messService.updateMess(messId, messDTO);
        	
        	return ResponseEntity.status(HttpStatus.OK).body(messService.updateMess(messId, messDTO));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
        
//        return ResponseEntity.ok(response);
        
    }
    
    @DeleteMapping("/{messId}")
    public ResponseEntity<?> deleteMess(@PathVariable Long messId) {
    	
    	try {
    		messService.deleteMess(messId);
    		return ResponseEntity.status(HttpStatus.OK).body(messService.deleteMess(messId));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
    	
    	
    }
    
    
    
    
    
    
    
    
    
}
