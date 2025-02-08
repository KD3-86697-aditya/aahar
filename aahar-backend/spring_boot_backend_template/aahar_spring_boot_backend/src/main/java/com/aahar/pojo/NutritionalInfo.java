package com.aahar.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "nutritional_info")
public class NutritionalInfo extends BaseEntity {

  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

    @Column(name = "calories_per_serving", nullable = false)
    private double caloriesPerServing;

    @Column(name = "protein_per_serving", nullable = false)
    private double proteinPerServing;

    @Column(name = "carbohydrates_per_serving", nullable = false)
    private double carbohydratesPerServing;

    @Column(name = "fat_per_serving", nullable = false)
    private double fatPerServing;
}
