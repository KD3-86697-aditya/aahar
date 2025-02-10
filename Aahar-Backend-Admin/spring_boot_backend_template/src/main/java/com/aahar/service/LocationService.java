package com.aahar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.daos.LocationRepository;
import com.aahar.dtos.LocationDTO;
import com.aahar.entity.Location;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    
    public String addLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setCity(locationDTO.getCity());
        
        locationRepository.save(location);
        return "Location added successfully";
    }
    
    public String deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return "Location deleted successfully";
    }
    
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
