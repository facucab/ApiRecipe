package com.recipe.RecipeBook.repository;

import com.recipe.RecipeBook.model.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<RecipeModel, Long> {

    List<RecipeModel> findByCategory(String category);

    @Query(value = "SELECT DISTINCT category FROM recipe;", nativeQuery = true)
    List<String> findDistinctCategory();

    @Query(value = "SELECT * FROM `recipe` WHERE duration < :max AND duration > :min", nativeQuery = true)
    List<RecipeModel> FilterByDurationMaxMin(@Param("max") int max, @Param("min") int min);

    @Query(value = "SELECT * FROM `recipe` WHERE duration > :min", nativeQuery = true)
    List<RecipeModel> FilterByDurationMin(@Param("min") int min);
}
