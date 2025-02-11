package com.aahar.service;




import com.aahar.daos.LocationRepository;
import com.aahar.dtos.LocationDTO;
import com.aahar.entity.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Add new location using DTO
    public String addLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setCity(locationDTO.getCity()); // Convert DTO to Entity
        locationRepository.save(location);
        return "Location added successfully!";
    }

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Transactional
    public boolean deleteLocation(Long id) {
        Optional<Location> location = locationRepository.findById(id);

        if (location.isPresent()) {
            locationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

