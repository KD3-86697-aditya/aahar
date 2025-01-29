package com.aahar.pojos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "menu_items") // Mapping to the MenuItems table
@Getter
@Setter
@ToString
public class MenuItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY) // Each menu item belongs to a specific mess
    @JoinColumn(name = "mess_id", nullable = false) // Foreign key referencing Messes table
    private Mess mess;

    @Column(length = 255, nullable = false)
    private String name; // Name of the menu item

    @Column(columnDefinition = "TEXT")
    private String description; // Description of the menu item

    @Column(nullable = false, precision = 10)
    private double price; // Price of the menu item

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable; // Availability status of the menu item

    @Enumerated(EnumType.STRING) // Storing enum as a string in the database
    @Column(nullable = false)
    private MealType type; // Type of the menu item (breakfast, lunch, dinner)

    public enum MealType {
        BREAKFAST, LUNCH, DINNER
    }
}
