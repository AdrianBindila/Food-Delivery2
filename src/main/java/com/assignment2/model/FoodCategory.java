package com.assignment2.model;

public enum FoodCategory {
    BREAKFAST("breakfast"),
    LUNCH("lunch"),
    DESSERT("dessert"),
    BEVERAGE("beverage");

    private final String label;
    FoodCategory(String label){
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
