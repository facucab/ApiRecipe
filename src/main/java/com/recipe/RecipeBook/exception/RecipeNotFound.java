package com.recipe.RecipeBook.exception;

public class RecipeNotFound extends  RuntimeException{
    public RecipeNotFound(String message) {
        super(message);
    }
}
