package com.recipe.RecipeBook.service;

import com.recipe.RecipeBook.dto.RecipeDTO;
import com.recipe.RecipeBook.exception.RecipeDataIntegrityException;
import com.recipe.RecipeBook.mapper.RecipeMapper;
import com.recipe.RecipeBook.model.RecipeModel;
import com.recipe.RecipeBook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

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

}
