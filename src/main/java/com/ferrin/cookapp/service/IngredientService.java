package com.ferrin.cookapp.service;

import com.ferrin.cookapp.dao.IngredientDAO;
import com.ferrin.cookapp.model.Ingredient;

import java.util.List;

public class IngredientService {

    private final IngredientDAO ingredientDAO = new IngredientDAO();

    public void saveIngredient(Ingredient ingredient) {
        ingredientDAO.saveIngredient(ingredient);
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientDAO.getAllIngredients();
    }

    public Ingredient findByName(String name) {
        return ingredientDAO.getIngredientByName(name);
    }
}
