package com.assignment2.model;

public enum FoodCategory {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DESSERT("Dessert"),
    BEVERAGE("Beverage");

    private final String label;
    FoodCategory(String label){
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
