package com.recipe.RecipeBook.exception;

public class RecipeDataIntegrityException extends  RuntimeException{

    public RecipeDataIntegrityException(String message) {
        super(message);
    }

    public RecipeDataIntegrityException() {
    }
}
