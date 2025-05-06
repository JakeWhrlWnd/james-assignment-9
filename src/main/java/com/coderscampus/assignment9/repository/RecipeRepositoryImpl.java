package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RecipeRepositoryImpl implements RecipeRepository {

    private final List<Recipe> recipeStorage = new ArrayList<>();

    @Override
    public void saveRecipes(List<Recipe> recipes) {
        recipeStorage.clear();
        recipeStorage.addAll(recipes);
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return new ArrayList<>(recipeStorage);
    }

    @Override
    public List<Recipe> findRecipesBy(Predicate<Recipe> filter) {
        return recipeStorage.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
