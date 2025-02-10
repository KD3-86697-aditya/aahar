package com.aahar.dtos;

import com.aahar.pojos.Location;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {
    private Long id;
    private String city;
    private String state;
    private String pincode;

    public LocationDTO(Long id, String city, String state, String pincode) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    
    public LocationDTO(Location location) {
        if (location != null) {
            this.city = location.getCity();
            this.state = location.getState();
            this.pincode = (location.getPincode() != null) ? location.getPincode().trim() : null;
        }
    }

   
}
