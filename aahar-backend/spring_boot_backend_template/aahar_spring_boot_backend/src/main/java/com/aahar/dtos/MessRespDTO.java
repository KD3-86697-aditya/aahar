package com.aahar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessRespDTO {
    private Long id;
    private String messName;
    private String address;
    private String description;
    private String contactNumber;
    private String openingHours;
    private LocationDTO location;  // Complete location details
    private Long messOwnerId;  // Keeping only the owner's ID
}
