package com.aahar.dtos;

import com.aahar.pojos.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Long locationId; // Reference to Location
    private UserRole role; // Role of the user
}
