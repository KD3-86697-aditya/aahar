package com.aahar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mess_id", nullable = false)
    private Mess mess;
    
    @Column(nullable = false)
    private String dishName;
    
    @Column(nullable = false)
    private Double price;
    
    @Column(nullable = false)
    private Boolean isAvailable;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealType mealType;
    
    public enum MealType {
        BREAKFAST, LUNCH, DINNER
    }
}

