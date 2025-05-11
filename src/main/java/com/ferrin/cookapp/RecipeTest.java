package com.ferrin.cookapp;

import com.ferrin.cookapp.dao.RecipeDAO;
import com.ferrin.cookapp.model.Recipe;

import java.util.List;

public class RecipeTest {
    public static void main(String[] args) {
        RecipeDAO recipeDAO = new RecipeDAO();

        // Insert a new recipe

        // Retrieve all recipes
        List<Recipe> recipes = recipeDAO.getAllRecipes();
        for (Recipe r : recipes) {
            System.out.println(r);
        }
    }
}
