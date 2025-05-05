package com.coderscampus.assignment9.web;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;
    private final List<Recipe> recipes;

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFree() {

        return null;
    }
// The “gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true
    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return null;
    }
// The “vegan” endpoint will only return a subset of the full Collection where vegan is true
    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return null;
    }
// The “vegan-and-gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true and
// vegan is true
    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return null;
    }
// The “vegetarian” endpoint will only return a subset of the full Collection where vegetarian is true
    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return recipes;
    }
// The “all-recipes” endpoint will not filter the data at all and should return the full Collection.


}
