package com.aahar.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminCreateDTO {
	@NotEmpty(message = "ADMIN NAME CANNOT BE BLANK")
    private String adminname;
	@NotEmpty(message = "PASSWORD CANNOT BE BLANK")
    private String password;
	@NotEmpty(message = "EMAIL CANNOT BE BLANK")
    private String email;
	@NotEmpty(message = "FIRST NAME CANNOT BE BLANK")
    private String firstName;
	@NotEmpty(message = "LAST NAME CANNOT BE BLANK")
    private String lastName;
	@NotEmpty(message = "PHONE NUMBER CANNOT BE BLANK")
    private String phoneNumber;
    
    
}
