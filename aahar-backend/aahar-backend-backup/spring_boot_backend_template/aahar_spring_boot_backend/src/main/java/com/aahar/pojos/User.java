package com.aahar.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users") // Mapping to the Users table
@Getter
@Setter
@ToString(callSuper = true) // Includes fields from BaseEntity in the toString
public class User extends BaseEntity {

    @Column(name = "username", unique = true, nullable = false, length = 255)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY) // Many users can share one location
    @JoinColumn(name = "location_id") // Foreign key column
    private Location location;

    @Enumerated(EnumType.STRING) // Store the enum as a string in the database
    @Column(name = "role", nullable = false)
    private UserRole role = UserRole.CUSTOMER; // Default role is CUSTOMER

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false; // Soft delete flag (false = active user)
}
