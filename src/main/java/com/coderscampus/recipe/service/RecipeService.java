package com.coderscampus.recipe.service;

import com.coderscampus.recipe.domain.Recipe;
import com.coderscampus.recipe.repository.RecipeRepository;
import com.coderscampus.recipe.utils.RecipeCSVMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    private static final CSVFormat RECIPE_CSV_FORMAT = CSVFormat.RFC4180.builder()
            .setHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price " +
                    "Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian")
            .setSkipHeaderRecord(true)
            .get();

    public List<Recipe> read(String fileName) {
        List<Recipe> recipeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            Iterable<CSVRecord> recipes = RECIPE_CSV_FORMAT.parse(reader);

            for (CSVRecord line : recipes) {
                System.out.println("Column count: " + line.size());
                try {
                    recipeList.add(RecipeCSVMapper.map(line));
                } catch (RuntimeException e) {
                    System.out.println("There was an issue parsing the CSV file, Issue " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("There was an issue reading the file, Issue " + e.getMessage());
        }

        return recipeList;
    }

    public void saveRecipes(List<Recipe> recipes) {
        recipeRepository.saveRecipes(recipes);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAllRecipes();
    }

    public List<Recipe> getVeganRecipes() {
        return recipeRepository.findRecipesBy(Recipe::isVegan);
    }

    public List<Recipe> getGlutenFree() {
        return recipeRepository.findRecipesBy(Recipe::isGlutenFree);
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return recipeRepository.findRecipesBy(recipe -> recipe.isVegan() && recipe.isGlutenFree());
    }

    public List<Recipe> getVegetarianRecipes() {
        return recipeRepository.findRecipesBy(Recipe::isVegetarian);
    }

    @PostConstruct
    public void init() {
        List<Recipe> recipes = read("recipes.txt");
        saveRecipes(recipes);
    }
}
