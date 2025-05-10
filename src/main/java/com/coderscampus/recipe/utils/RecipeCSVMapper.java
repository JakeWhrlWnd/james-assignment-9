package com.coderscampus.recipe.utils;

import com.coderscampus.recipe.domain.Recipe;
import org.apache.commons.csv.CSVRecord;

public class RecipeCSVMapper {

        public static Recipe map(CSVRecord line) {
                return new Recipe(parseInt(line.get("Cooking Minutes")),
                        Boolean.parseBoolean(line.get("Dairy Free")),
                        Boolean.parseBoolean(line.get("Gluten Free")),
                        getOrDefault(line.get("Instructions"), "No instructions provided"),
                        parseDouble(line.get("Preparation Minutes")),
                        parseDouble(line.get("Price Per Serving")),
                        parseInt(line.get("Ready In Minutes")),
                        parseInt(line.get("Servings")),
                        parseDouble(line.get("Spoonacular Score")),
                        getOrDefault(line.get("Title"), "No title provided"),
                        Boolean.parseBoolean(line.get("Vegan")),
                        Boolean.parseBoolean(line.get("Vegetarian")));
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
                return (input == null || input.isBlank()) ? fallback : input.trim();
        }
}
