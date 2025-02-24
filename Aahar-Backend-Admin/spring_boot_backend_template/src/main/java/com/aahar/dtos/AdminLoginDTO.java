package com.aahar.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AdminLoginDTO {
	@NotEmpty(message = "ADMINNAME CANNOT BE BLANK")
	private String adminname;
	@NotEmpty(message = "PASSWORD CANNOT BE BLANK")
	private String password;

}
