package com.recipe.RecipeBook.service;

import com.recipe.RecipeBook.dto.RecipeDTO;
import com.recipe.RecipeBook.exception.RecipeDataIntegrityException;
import com.recipe.RecipeBook.exception.RecipeNotFound;
import com.recipe.RecipeBook.mapper.RecipeMapper;
import com.recipe.RecipeBook.model.RecipeModel;
import com.recipe.RecipeBook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private  RecipeRepository recipeRepository;



    public RecipeDTO CreateRecipe(RecipeDTO r) throws RecipeDataIntegrityException
    {

        RecipeModel recipe = RecipeMapper.DTOtoModel(r);
        try
        {
            recipeRepository.save(recipe);
        }
        catch (DataIntegrityViolationException e)
        {
            throw new RecipeDataIntegrityException(e.getMessage());
        }

        return  r;
    }


    public List<RecipeDTO> AllRecipe()
    {
        return RecipeMapper.ListModelToDto(
                    recipeRepository.findAll()
                );
    }

    public RecipeDTO SelectRecipeById(long id) throws RecipeNotFound
    {
        RecipeModel recipeModel = recipeRepository.findById(id).orElseThrow(
                () -> new RecipeNotFound("Recipe Not Found")
        );
        return  RecipeMapper.ModelToDTO(recipeModel);
    }

    public RecipeDTO UpdateById(long id, RecipeDTO recipeDTO)
    {
        RecipeModel recipeModelDB = recipeRepository.findById(id).orElseThrow(
                () -> new RecipeNotFound("Recipe Not Found")
        );
        //
        recipeModelDB.setTitle(recipeDTO.getTitle());
        recipeModelDB.setDescription(recipeDTO.getDescription() );
        recipeModelDB.setDuration(recipeDTO.getDuration());
        recipeModelDB.setCategory(recipeDTO.getCategory());

        //
        try
        {
            recipeRepository.save(recipeModelDB);
        }
        catch (DataIntegrityViolationException e)
        {
            throw  new RecipeDataIntegrityException();
        }
        return recipeDTO;
    }


    public List<RecipeDTO> SearchByCategory(String category)
    {
        return  RecipeMapper.ListModelToDto(
                    recipeRepository.findByCategory(category)
                );
    }

    public List<String> AllCategory()
    {
        return recipeRepository.findDistinctCategory();
    }
}
