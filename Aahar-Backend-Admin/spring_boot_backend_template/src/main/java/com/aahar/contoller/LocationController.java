package com.aahar.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aahar.dtos.LocationDTO;
import com.aahar.entity.Location;
import com.aahar.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;
    
    @PostMapping("/add")
    public String addLocation(@RequestBody LocationDTO locationDTO) {
        return locationService.addLocation(locationDTO);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        return locationService.deleteLocation(id);
    }
    
    @GetMapping("/all")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }
}
