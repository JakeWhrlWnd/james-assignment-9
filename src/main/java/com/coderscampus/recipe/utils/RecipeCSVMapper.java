package com.coderscampus.recipe.utils;

import com.coderscampus.recipe.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RecipeCSVMapper {

    private static final CSVFormat RECIPE_CSV_FORMAT = CSVFormat.DEFAULT.builder()
            .setHeader()
            .setIgnoreSurroundingSpaces(true)
            .setSkipHeaderRecord(true)
            .setQuote('"')
            .setEscape('\\')
            .setTrim(true)
            .get();

    public static List<Recipe> mapAll(Reader reader) {
        List<Recipe> recipes = new ArrayList<>();
        try {
            Iterable<CSVRecord> lines = RECIPE_CSV_FORMAT.parse(reader);
            for (CSVRecord line : lines) {
                try {
                    recipes.add(RecipeCSVMapper.map(line));
                } catch (RuntimeException e) {
                    System.out.println("There was an issue parsing the CSV file, Issue " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("There was an issue parsing the CSV file, Issue " + e.getMessage());
        }
        return recipes;
    }

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
