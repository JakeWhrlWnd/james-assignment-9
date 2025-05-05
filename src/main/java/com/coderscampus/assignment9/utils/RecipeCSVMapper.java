package com.coderscampus.assignment9.utils;

import com.coderscampus.assignment9.domain.Recipe;
import org.apache.commons.csv.CSVRecord;

public class RecipeCSVMapper {

        public static Recipe map(CSVRecord line) {
                int cookingMinutes = parseInt(line.get("Cooking Minutes"), 0);
                boolean dairyFree = Boolean.parseBoolean(line.get("Dairy Free"));
                boolean glutenFree = Boolean.parseBoolean(line.get("Gluten Free"));
                String instructions = getOrDefault(line.get("Instructions"), "No instructions provided");
                double preparationMinutes = parseDouble(line.get("Preparation Minutes"), 0.0);
                double pricePerServing = parseDouble(line.get("Price Per Serving"), 0.0);
                int readyInMinutes = parseInt(line.get("Ready In Minutes"), 0);
                int servings = parseInt(line.get("Servings"), 0);
                double spoonacularScore = parseDouble(line.get("Spoonacular Score"), 0.0);
                String title = getOrDefault(line.get("Title"), "No title provided");
                boolean vegan = Boolean.parseBoolean(line.get("Vegan"));
                boolean vegetarian = Boolean.parseBoolean(line.get("Vegetarian"));

                return new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes, pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);
        }
        private static Integer parseInt(String input, int defaultValue) {
                try {
                        return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                        System.out.println("Input is not an integer");
                        return defaultValue;
                }
        }

        private static Double parseDouble(String input, double defaultValue) {
                try {
                        return Double.parseDouble(input);
                } catch (NumberFormatException e) {
                        System.out.println("Input is not a double");
                        return defaultValue;
                }
        }

        private static String getOrDefault(String input, String fallback) {
                return (input == null || input.isBlank()) ? fallback : input.trim();
        }
}
