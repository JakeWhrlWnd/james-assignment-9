package com.coderscampus.recipe.repository;

import com.coderscampus.recipe.domain.Recipe;
import com.coderscampus.recipe.utils.RecipeCSVMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class RecipeRepository {

    private final List<Recipe> recipeStorage = new ArrayList<>();

    @PostConstruct
    public void init() {
        List<Recipe> recipes = read("recipes.txt");
        saveRecipes(recipes);
    }

    private void saveRecipes(List<Recipe> recipes) {
        recipeStorage.clear();
        recipeStorage.addAll(recipes);
    }

    public List<Recipe> findAllRecipes() {
        return new ArrayList<>(recipeStorage);
    }

    public List<Recipe> findRecipesBy(Predicate<Recipe> filter) {
        return recipeStorage.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    private List<Recipe> read(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            return RecipeCSVMapper.mapAll(reader);
        } catch (IOException e) {
            System.out.println("There was an issue reading the file, Issue " + e.getMessage());
            return List.of();
        }
    }
}
