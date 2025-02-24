package com.aahar.contoller;






import com.aahar.dtos.LocationDTO;
import com.aahar.entity.Location;
import com.aahar.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:3000") // Enable CORS
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Add a new location
    @PostMapping("/add")
    public ResponseEntity<String> addLocation(@RequestBody LocationDTO locationDTO) {
        String result = locationService.addLocation(locationDTO);
        return ResponseEntity.ok(result);
    }

    // Get all locations
    @GetMapping("/all")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        boolean isDeleted = locationService.deleteLocation(id);
        if (isDeleted) {
            return ResponseEntity.ok("Location deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Location not found!");
        }
    }

}


