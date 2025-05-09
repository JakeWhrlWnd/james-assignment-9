package com.coderscampus.recipe.utils;

import com.coderscampus.recipe.domain.Recipe;
import org.apache.commons.csv.CSVRecord;

public class RecipeCSVMapper {

        private final static Recipe recipe = new Recipe();

        public static Recipe map(CSVRecord line) {

                recipe.setCookingMinutes(parseInt(line.get("Cooking Minutes")));
                recipe.setDairyFree(Boolean.parseBoolean(line.get("Dairy Free")));
                recipe.setGlutenFree(Boolean.parseBoolean(line.get("Gluten Free")));
                recipe.setInstructions(getOrDefault(line.get("Instructions"), "No instructions provided"));
                recipe.setPreparationMinutes(parseDouble(line.get("Preparation Minutes")));
                recipe.setPricePerServing(parseDouble(line.get("Price Per Serving")));
                recipe.setReadyInMinutes(parseInt(line.get("Ready In Minutes")));
                recipe.setServings(parseInt(line.get("Servings")));
                recipe.setSpoonacularScore(parseDouble(line.get("Spoonacular Score")));
                recipe.setTitle(getOrDefault(line.get("Title"), "No title provided"));
                recipe.setVegan(Boolean.parseBoolean(line.get("Vegan")));
                recipe.setVegetarian(Boolean.parseBoolean(line.get("Vegetarian")));

                return new Recipe(recipe.getCookingMinutes(), recipe.isDairyFree(), recipe.isGlutenFree(),
                        recipe.getInstructions(), recipe.getPreparationMinutes(), recipe.getPricePerServing(),
                        recipe.getReadyInMinutes(), recipe.getServings(), recipe.getSpoonacularScore(),
                        recipe.getTitle(), recipe.isVegan(), recipe.isVegetarian());
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
