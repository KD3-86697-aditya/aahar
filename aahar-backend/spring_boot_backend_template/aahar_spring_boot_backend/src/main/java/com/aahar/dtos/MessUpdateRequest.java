package com.aahar.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MessUpdateRequest {
    private String messName;
    private String firstName;
    private String lastName;
    private String ownerPhone;
    private String ownerEmail;
    private String address;
    private LocationDTO location;
}
