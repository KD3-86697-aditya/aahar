package com.aahar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserProfileDto {
	
	private String username;
	private String phoneNumber;
	private String city;
	private String pincode;
	private String state;
}
