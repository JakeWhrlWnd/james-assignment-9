package com.coderscampus.assignment9.domain;

import org.apache.commons.csv.CSVRecord;

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

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Double getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(Double preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Double getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(Double spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
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

    public static Recipe fromCSV(CSVRecord line) {
        int cookingMinutes = Integer.parseInt(line.get("Cooking Minutes"));
        boolean dairyFree = Boolean.parseBoolean(line.get("Dairy Free"));
        boolean glutenFree = Boolean.parseBoolean(line.get("Gluten Free"));
        String instructions = line.get("Instructions");
        double preparationMinutes = Double.parseDouble(line.get("Preparation Minutes"));
        double pricePerServing = Double.parseDouble(line.get("Price Per Serving"));
        int readyInMinutes = Integer.parseInt(line.get("Ready In Minutes"));
        int servings = Integer.parseInt(line.get("Servings"));
        double spoonacularScore = Double.parseDouble(line.get("Spoonacular Score"));
        String title = line.get("Title");
        boolean vegan = Boolean.parseBoolean(line.get("Vegan"));
        boolean vegetarian = Boolean.parseBoolean(line.get("Vegetarian"));

        return new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes, pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);
    }
}
