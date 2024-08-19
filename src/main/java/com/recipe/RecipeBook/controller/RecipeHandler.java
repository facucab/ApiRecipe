package com.recipe.RecipeBook.controller;

import com.recipe.RecipeBook.exception.RecipeDataIntegrityException;
import com.recipe.RecipeBook.exception.RecipeNotFound;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class RecipeHandler {

    @ExceptionHandler(RecipeDataIntegrityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> DataIntegrity(RecipeDataIntegrityException e)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "data integrity violation error");
        //response.put("details", e.getLocalizedMessage());
        return  response;
    }

    @ExceptionHandler(RecipeNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> RecipeNotFoundHandler (RecipeNotFound e)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", e.getLocalizedMessage());
        return response;
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> NumberFormatExcetionHandler()
    {
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Error Number Format");
        return response;
    }

}
