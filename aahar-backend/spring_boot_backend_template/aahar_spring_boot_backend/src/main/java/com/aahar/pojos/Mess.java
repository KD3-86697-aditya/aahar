package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "messes")
public class Mess extends BaseEntity {

    @Column(name = "mess_name", nullable = false, length = 255)
    private String messName;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "opening_hours", length = 255)
    private String openingHours;

    @ManyToOne
    @JoinColumn(name = "mess_owner_id", nullable = false)
    private User messOwner;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false; // Default to false (not deleted)

    // Soft delete method
    public void softDelete() {
        this.deleted = true;
    }
}
