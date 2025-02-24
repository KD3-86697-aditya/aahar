package com.aahar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "messes")
public class Mess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 255)
    private String messName;
    
    @Column(columnDefinition = "TEXT")
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(length = 20)
    private String contactNumber;
    
    @Column(length = 255)
    private String openingHours;
    
    @ManyToOne
    @JoinColumn(name = "mess_owner_id", nullable = false)
    private Admin messOwner;
    
    @Column(nullable = false)
    private boolean deleted = false;
    
    public void softDelete() {
        this.deleted = true;
    }
}
