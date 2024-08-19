package com.recipe.RecipeBook.mapper;

import com.recipe.RecipeBook.dto.RecipeDTO;
import com.recipe.RecipeBook.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

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


    // List<RecipeModel> ->  List<RecipeDTO>

    public static List<RecipeDTO> ListModelToDto(List<RecipeModel> listModel)
    {
        List<RecipeDTO> ListRecipeDTO =  new ArrayList<>();
        for (RecipeModel item: listModel )
        {
            ListRecipeDTO.add(ModelToDTO(item));
        }
        return  ListRecipeDTO;
    }
}
