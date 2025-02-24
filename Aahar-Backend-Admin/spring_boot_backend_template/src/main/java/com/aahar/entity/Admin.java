package com.aahar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name ="admins")
public class Admin extends BaseClass {
	

	@Column(nullable = false, unique = true)
	@NotEmpty(message = "ADMIN NAME CANNOT BE BLANK")
    private String adminname;
    
    @Column(nullable = false)
    @NotEmpty(message = "PASSWORD CANNOT BE BLANK")
    private String password;
    
    @Column(nullable = false , unique = true)
    @NotEmpty(message = "EMAIL CANNOT BE BLANK")
	private String email;
    
    @Column(nullable = false)
    @NotEmpty(message = "FIRST NAME CANNOT BE BLANK")
    private String firstName;
    
    @NotEmpty(message = "LAST NAME CANNOT BE BLANK")
    @Column(nullable = false)
    private String lastName;
    
    
    @Column(nullable = false, unique = true)
    private String phoneNumber;
	
	
	
}
