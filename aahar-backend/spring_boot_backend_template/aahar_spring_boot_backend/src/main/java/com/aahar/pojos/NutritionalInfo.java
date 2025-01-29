package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "nutritional_info") // Mapping to the NutritionalInfo table
@Getter
@Setter
@ToString
public class NutritionalInfo extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY) // Each NutritionalInfo is associated with a specific MenuItem
    @JoinColumn(name = "menu_item_id", nullable = false, unique = true) // Foreign key referencing MenuItems table
    private MenuItem menuItem;

    @Column(name = "calories_per_serving", nullable = false, precision = 10)
    private double caloriesPerServing; // Calories per serving

    @Column(name = "protein_per_serving", nullable = false, precision = 10)
    private double proteinPerServing; // Protein content per serving

    @Column(name = "carbohydrates_per_serving", nullable = false, precision = 10)
    private double carbohydratesPerServing; // Carbohydrate content per serving

    @Column(name = "fat_per_serving", nullable = false, precision = 10)
    private double fatPerServing; // Fat content per serving
}
