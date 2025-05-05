package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Predicate;

@Repository
public interface RecipeRepository {
    void saveRecipes(List<Recipe> recipes);
    List<Recipe> findAllRecipes();
    List<Recipe> findRecipesByCategory(Predicate<Recipe> category);
}
