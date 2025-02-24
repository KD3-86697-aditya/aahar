package com.aahar.dtos;

public class MenuItemDTO {
    private Long id;
    private Long messId;
    private String dishName;
    private Double price;
    private Boolean isAvailable;
    private String mealType;

    // Default constructor
    public MenuItemDTO() {
    }

    // Constructor with all parameters
    public MenuItemDTO(Long id, Long messId, String dishName, Double price, Boolean isAvailable, String mealType) {
        this.id = id;
        this.messId = messId;
        this.dishName = dishName;
        this.price = price;
        this.isAvailable = isAvailable;
        this.mealType = mealType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessId() {
        return messId;
    }

    public void setMessId(Long messId) {
        this.messId = messId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
