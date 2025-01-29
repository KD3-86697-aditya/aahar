package com.aahar.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "messes") // Mapping to the Messes table
@Getter
@Setter
@ToString
public class Mess extends BaseEntity {

    @Column(name = "mess_name", nullable = false, length = 255)
    private String messName;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY) // Many messes can be in one location
    @JoinColumn(name = "location_id") // Foreign key column referencing Locations table
    private Location location;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "opening_hours", length = 255)
    private String openingHours;

    @ManyToOne(fetch = FetchType.LAZY) // Each mess is owned by one user (mess owner)
    @JoinColumn(name = "mess_owner_id") // Foreign key column referencing Users table
    private User messOwner;
}
