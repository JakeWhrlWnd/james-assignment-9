package com.coderscampus.assignment9.repository;

import com.coderscampus.assignment9.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository {
    Optional<Recipe> findByTitle(String title);
}
