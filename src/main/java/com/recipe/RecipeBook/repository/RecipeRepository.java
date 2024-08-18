package com.recipe.RecipeBook.repository;

import com.recipe.RecipeBook.model.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeModel, Long> {


}
