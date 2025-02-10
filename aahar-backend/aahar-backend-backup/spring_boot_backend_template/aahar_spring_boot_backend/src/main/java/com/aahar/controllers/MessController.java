package com.aahar.controllers;


import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.MessReqDTO;
import com.aahar.dtos.MessRespDTO;
import com.aahar.dtos.MessUpdateRequest;
import com.aahar.dtos.MessUpdateResponse;
import com.aahar.pojos.Mess;
import com.aahar.service.MessService;

import jakarta.persistence.EntityNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @PutMapping("/mess/{messId}")
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
    
    
    @GetMapping("/{messId}")
    public ResponseEntity<?> getMessDetails(@PathVariable Long messId) {
        Mess mess = messService.getMessDetails(messId);
        
        System.out.println("this is mess " +  mess);
        
        if (mess == null) {
            return ResponseEntity.notFound().build();
        }

        // Construct a response with mess and owner details
        Map<String, Object> response = new HashMap<>();
        response.put("messName", mess.getMessName());
//        response.put("address", mess.getAddress());
        response.put("location", mess.getLocation().getCity() + ", " + mess.getLocation().getState());
        response.put("firstName", mess.getMessOwner().getFirstName());
        response.put("lastName", mess.getMessOwner().getLastName());
        response.put("ownerEmail", mess.getMessOwner().getEmail());
        response.put("ownerPhone", mess.getMessOwner().getPhoneNumber());
        response.put("pincode", mess.getLocation().getPincode());

        System.out.println("this is response"+response);
        
        return ResponseEntity.ok(response);
    }
//    										
//    @PutMapping("/{messId}")
//    public ResponseEntity<MessUpdateResponse> updateMessDetails(
//            @PathVariable Long messId,
//            @RequestBody MessUpdateRequest request) {
//        return ResponseEntity.ok(messService.updateMessDetails(messId, request));
//    }
    
    
    @PutMapping("/{messId}")
    public ResponseEntity<?> updateMessDetails(@PathVariable Long messId, @RequestBody MessUpdateRequest request) {
        Mess mess = messService.updateMessDetails(messId, request);

        if (mess == null) {
            return ResponseEntity.notFound().build();
        }

        // Construct a response similar to the GET response
        Map<String, Object> response = new HashMap<>();
        response.put("messName", mess.getMessName());
//         response.put("address", mess.getAddress()); // Uncomment if address is needed
        response.put("location", mess.getLocation().getCity() + ", " + mess.getLocation().getState());
        response.put("firstName", mess.getMessOwner().getFirstName());
        response.put("lastName", mess.getMessOwner().getLastName());
        response.put("ownerEmail", mess.getMessOwner().getEmail());
        response.put("ownerPhone", mess.getMessOwner().getPhoneNumber());
        response.put("pincode", mess.getLocation().getPincode());

        return ResponseEntity.ok(response);
    }
    
    
    @GetMapping("/user-mess/{messId}")
    public ResponseEntity<?> getMessDetailsForUser(@PathVariable Long messId) {
        try {
        	MessRespDTO mess = messService.getMessDetailsForUser(messId);
            return ResponseEntity.status(HttpStatus.OK).body(mess);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Mess not found"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
        }
    }
    
    

    @GetMapping("/search")
    public ResponseEntity<?> searchMesses(@RequestParam String searchQuery) {
        try {
            List<MessRespDTO> messList = messService.searchMesses(searchQuery);
            return ResponseEntity.status(HttpStatus.OK).body(messList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
        }
    }
   
    
    @GetMapping("/city/{city}")
    public ResponseEntity<?> getMessesByCity(@PathVariable String city) {
        try {
            List<MessRespDTO> messList = messService.getMessesByCity(city);
            return ResponseEntity.status(HttpStatus.OK).body(messList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
        }
    }
    
   
}
