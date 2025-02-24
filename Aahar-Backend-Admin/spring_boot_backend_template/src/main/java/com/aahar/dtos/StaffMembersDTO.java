package com.aahar.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffMembersDTO {
	private String name;
    private String address;
    private Date dob;
    private String gender;
    private String mobileNo;
    private String role;
}

