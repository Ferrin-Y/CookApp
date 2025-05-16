package com.ferrin.cookapp.service;

import com.ferrin.cookapp.dao.QuantityDAO;
import com.ferrin.cookapp.dao.RecipeDAO;
import com.ferrin.cookapp.model.Ingredient;
import com.ferrin.cookapp.model.Quantity;
import com.ferrin.cookapp.model.Recipe;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {

    private final RecipeDAO recipeDAO = new RecipeDAO();
    private final QuantityDAO quantityDAO = new QuantityDAO();

    public void saveRecipe(Recipe recipe) {
        recipeDAO.saveRecipe(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeDAO.getAllRecipes();
    }

    public List<Recipe> searchRecipes(List<String> ingredients, String cuisine, int maxCookTime,
                                      boolean vegan, boolean vegetarian, boolean glutenFree) {
        List<Recipe> allRecipes = recipeDAO.getAllRecipes();

        return allRecipes.stream()
                .filter(recipe -> {
                    if (ingredients == null || ingredients.isEmpty()) return true;

                    List<Quantity> quantities = quantityDAO.getQuantitiesForRecipe(recipe.getId());

                    return ingredients.stream().allMatch(input ->
                            quantities.stream().anyMatch(q ->
                                    q.getIngredient().getName().toLowerCase().contains(input.toLowerCase()))
                    );
                })
                .filter(recipe -> cuisine == null || cuisine.equalsIgnoreCase("Any") ||
                        recipe.getCuisine().equalsIgnoreCase(cuisine))
                .filter(recipe -> recipe.getCookingTime() <= maxCookTime)
                .filter(recipe -> {
                    String tag = recipe.getDietaryTag().toLowerCase();
                    if (vegan && !tag.contains("vegan")) return false;
                    if (vegetarian && !tag.contains("vegetarian") && !tag.contains("vegan")) return false;
                    if (glutenFree && !tag.contains("gluten-free")) return false;
                    return true;
                })
                .collect(Collectors.toList());
    }

    public List<String> getDistinctCuisines() {
        // Get all recipes first
        List<Recipe> allRecipes = recipeDAO.getAllRecipes();

        // Extract distinct cuisines
        List<String> cuisines = allRecipes.stream()
                .map(Recipe::getCuisine)
                .distinct()
                .filter(cuisine -> cuisine != null && !cuisine.trim().isEmpty())
                .collect(Collectors.toList());

        // Sort alphabetically
        Collections.sort(cuisines);

        return cuisines;
    }
}
