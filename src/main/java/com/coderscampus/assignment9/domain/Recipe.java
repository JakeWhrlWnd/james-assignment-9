package com.coderscampus.assignment9.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Recipe {
    private int cookingMinutes;
    private boolean dairyFree;
    private boolean glutenFree;
    private String instructions;
    private double preparationMinutes;
    private double pricePerServing;
    private int readyInMinutes;
    private int servings;
    private double spoonacularScore;
    private String title;
    private boolean vegan;
    private boolean vegetarian;

    public Recipe() {
    }

    public Recipe(int cookingMinutes, boolean dairyFree, boolean glutenFree, String instructions, double preparationMinutes, double pricePerServing, int readyInMinutes, int servings, double spoonacularScore, String title, boolean vegan, boolean vegetarian) {
        this.cookingMinutes = cookingMinutes;
        this.dairyFree = dairyFree;
        this.glutenFree = glutenFree;
        this.instructions = instructions;
        this.preparationMinutes = preparationMinutes;
        this.pricePerServing = pricePerServing;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.spoonacularScore = spoonacularScore;
        this.title = title;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "cookingMinutes=" + cookingMinutes +
                ", dairyFree=" + dairyFree +
                ", glutenFree=" + glutenFree +
                ", instructions='" + instructions + '\'' +
                ", preparationMinutes=" + preparationMinutes +
                ", pricePerServing=" + pricePerServing +
                ", readyInMinutes=" + readyInMinutes +
                ", servings=" + servings +
                ", spoonacularScore=" + spoonacularScore +
                ", title='" + title + '\'' +
                ", vegan=" + vegan +
                ", vegetarian=" + vegetarian +
                '}';
    }
}
