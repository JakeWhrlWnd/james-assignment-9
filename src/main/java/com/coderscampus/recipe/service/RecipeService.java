package com.coderscampus.recipe.service;

import com.coderscampus.recipe.domain.Recipe;
import com.coderscampus.recipe.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

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
}
