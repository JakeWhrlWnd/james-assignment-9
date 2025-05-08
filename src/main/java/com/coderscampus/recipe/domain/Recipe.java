package com.coderscampus.recipe.domain;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
}
