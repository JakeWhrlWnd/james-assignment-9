package com.coderscampus.recipe.utils;

import com.coderscampus.recipe.domain.Recipe;
import org.apache.commons.csv.CSVRecord;

public class RecipeCSVMapper {

        public static Recipe map(CSVRecord line) {

                int cookingMinutes = parseInt(line.get("Cooking Minutes"));
                boolean dairyFree = Boolean.parseBoolean(line.get("Dairy Free"));
                boolean glutenFree = Boolean.parseBoolean(line.get("Gluten Free"));
                String instructions = getOrDefault(line.get("Instructions"), "No instructions provided");
                double preparationMinutes = parseDouble(line.get("Preparation Minutes"));
                double pricePerServing = parseDouble(line.get("Price Per Serving"));
                int readyInMinutes = parseInt(line.get("Ready In Minutes"));
                int servings = parseInt(line.get("Servings"));
                double spoonacularScore = parseDouble(line.get("Spoonacular Score"));
                String title = getOrDefault(line.get("Title"), "No title provided");
                boolean vegan = Boolean.parseBoolean(line.get("Vegan"));
                boolean vegetarian = Boolean.parseBoolean(line.get("Vegetarian"));

                return new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes,
                        pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);
        }

        private static Integer parseInt(String input) {
                try {
                        return Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                        System.out.println("Input is not an integer");
                        return 0;
                }
        }

        private static Double parseDouble(String input) {
                try {
                        return Double.parseDouble(input.trim());
                } catch (NumberFormatException e) {
                        System.out.println("Input is not a double");
                        return 0.0;
                }
        }

        private static String getOrDefault(String input, String fallback) {
                return (input == null || input.isBlank()) ? input : fallback;
        }
}
