package com.recipe.RecipeBook.mapper;

import com.recipe.RecipeBook.dto.RecipeDTO;
import com.recipe.RecipeBook.model.RecipeModel;

public class RecipeMapper {

    // RecipeDTO => RecipeModel
    public static RecipeModel DTOtoModel(RecipeDTO r)
    {
        return new RecipeModel(
                r.getTitle(),
                r.getDescription(),
                r.getDuration(),
                r.getCategory()
        );
    }

    // RecipeModel => RecipeDto
    public static RecipeDTO ModelToDTO(RecipeModel r)
    {
        return new RecipeDTO(r.getTitle(),
                r.getDescription(),
                r.getDuration(),
                r.getCategory()
        );
    }

}
