package com.recipe.RecipeBook.controller;

import com.recipe.RecipeBook.dto.RecipeDTO;
import com.recipe.RecipeBook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


     @GetMapping("/all")
    public List<RecipeDTO> AllRecipe()
     {
         return  recipeService.AllRecipe();
     }

     @GetMapping("{id}")
    public RecipeDTO SelectRecipeById(@PathVariable long id)
     {

         return recipeService.SelectRecipeById(id);
     }

     @PutMapping("/update")
    public RecipeDTO UpdateById(@RequestParam("id") long id, @RequestBody RecipeDTO r)
     {
         return recipeService.UpdateById(id, r);
     }

     @GetMapping("/search/{category}")
    public List<RecipeDTO> SearchByCategory(@PathVariable String category)
     {
         return recipeService.SearchByCategory(category);
     }

     @GetMapping("/categorys")
    public List<String> AllCategory()
     {
         return recipeService.AllCategory();
     }

     @DeleteMapping("delete/{id}")
    public RecipeDTO DeleteById(@PathVariable long id)
     {
         return recipeService.DeleteById(id);
     }

     @GetMapping("/filter")
    public List<RecipeDTO> FilterByDuration(@RequestParam(value = "max", required = false) Integer max, @RequestParam("min") Integer min)
     {
         return recipeService.FilterByDuration(max, min);
     }
}
