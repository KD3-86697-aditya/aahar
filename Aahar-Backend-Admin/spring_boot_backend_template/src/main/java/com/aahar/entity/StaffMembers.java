package com.aahar.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class StaffMembers extends BaseClass {
	@Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private Date dob;
    
    @Column(nullable = false)
    private String gender;
    
    @Column(nullable = false, unique = true)
    private String mobileNo;
    
    @Column(nullable = false)
    private String role;
}
