package com.coderscampus.assignment9.service;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;
import com.coderscampus.assignment9.utils.RecipeCSVMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    private static final CSVFormat RECIPE_CSV_FORMAT = CSVFormat.DEFAULT.builder()
            .setHeader()
            .setIgnoreHeaderCase(true)
            .setTrim(true)
            .get();

    public List<Recipe> read(String fileName) {
        List<Recipe> recipeList = new ArrayList<>();

        try (Reader in = new FileReader(fileName)) {
            Iterable<CSVRecord> recipes = RECIPE_CSV_FORMAT.parse(in);

            for (CSVRecord line : recipes) {
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
}
