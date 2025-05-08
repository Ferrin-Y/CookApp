package com.ferrin.cookapp;

import com.ferrin.cookapp.dao.RecipeDAO;
import com.ferrin.cookapp.model.Recipe;

import java.util.List;

public class RecipeTest {
    public static void main(String[] args) {
        RecipeDAO recipeDAO = new RecipeDAO();

        // Insert a new recipe
        Recipe recipe = new Recipe("Mac & Cheese", "Macaroni, Cheese, Milk", "1. Boil pasta\n2. Add cheese and milk\n3. Stir until melted");
        recipeDAO.saveRecipe(recipe);

        // Retrieve all recipes
        List<Recipe> recipes = recipeDAO.getAllRecipes();
        for (Recipe r : recipes) {
            System.out.println(r);
        }
    }
}
