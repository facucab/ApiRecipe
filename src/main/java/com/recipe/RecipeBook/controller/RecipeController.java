package com.recipe.RecipeBook.controller;

import com.recipe.RecipeBook.dto.RecipeDTO;
import com.recipe.RecipeBook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    @PostMapping("/create")
    public ResponseEntity<RecipeDTO> CreateRecipe(@RequestBody RecipeDTO recipe)
     {
         return  ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(
                         recipeService.CreateRecipe(recipe)
                 );
     }
}
