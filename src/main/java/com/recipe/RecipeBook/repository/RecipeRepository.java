package com.recipe.RecipeBook.repository;

import com.recipe.RecipeBook.model.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeModel, Long> {

    List<RecipeModel> findByCategory(String category);

    @Query(value = "SELECT DISTINCT category FROM recipe;", nativeQuery = true)
    List<String> findDistinctCategory();

}
