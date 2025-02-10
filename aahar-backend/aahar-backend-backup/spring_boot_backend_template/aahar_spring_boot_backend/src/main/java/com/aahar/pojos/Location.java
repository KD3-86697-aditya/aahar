package com.aahar.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "locations") // Mapping to the Locations table
@Getter
@Setter
@ToString
public class Location extends BaseEntity {

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "state", length = 255)
    private String state;

    @Column(name = "pincode", length = 10)
    private String pincode;
    
    public void setPincode(String pincode) {
        this.pincode = (pincode != null) ? pincode.trim() : null;
    }

}
