package com.coderscampus.recipe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "Title",
        "Spoonacular Score",
        "Servings",
        "Price Per Serving",
        "Preparation Minutes",
        "Cooking Minutes",
        "Ready In Minutes",
        "Dairy Free",
        "Gluten Free",
        "Vegetarian",
        "Vegan",
        "Instructions"
})
public class Recipe {
    @JsonProperty("Cooking Minutes")
    private int cookingMinutes;
    @JsonProperty("Dairy Free")
    private boolean dairyFree;
    @JsonProperty("Gluten Free")
    private boolean glutenFree;
    @JsonProperty("Instructions")
    private String instructions;
    @JsonProperty("Preparation Minutes")
    private double preparationMinutes;
    @JsonProperty("Price Per Serving")
    private double pricePerServing;
    @JsonProperty("Ready In Minutes")
    private int readyInMinutes;
    @JsonProperty("Servings")
    private int servings;
    @JsonProperty("Spoonacular Score")
    private double spoonacularScore;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Vegan")
    private boolean vegan;
    @JsonProperty("Vegetarian")
    private boolean vegetarian;

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
