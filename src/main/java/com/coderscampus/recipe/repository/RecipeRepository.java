package com.coderscampus.recipe.repository;

import com.coderscampus.recipe.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Predicate;

@Repository
public interface RecipeRepository {
    void saveRecipes(List<Recipe> recipes);
    List<Recipe> findAllRecipes();
    List<Recipe> findRecipesBy(Predicate<Recipe> filter);
}
