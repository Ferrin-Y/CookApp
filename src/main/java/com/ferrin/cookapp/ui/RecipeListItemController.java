package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Quantity;
import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.service.QuantityService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class RecipeListItemController {

    @FXML private Label nameLabel;
    @FXML private Label ingredientsLabel;
    @FXML private Label instructionsLabel;

    private final QuantityService quantityService = new QuantityService();

    public void setRecipe(Recipe recipe) {
        nameLabel.setText(recipe.getName());
        instructionsLabel.setText("Instructions: " + recipe.getInstructions());

        // Fetch quantities from DB
        List<Quantity> quantities = quantityService.getQuantitiesForRecipe(recipe.getId());

        // Build ingredients display
        StringBuilder ingredientsText = new StringBuilder("Ingredients: ");
        for (Quantity q : quantities) {
            ingredientsText.append(q.getAmount())
                    .append(" ")
                    .append(q.getUnit())
                    .append(" ")
                    .append(q.getIngredient().getName())
                    .append(", ");
        }

        if (!quantities.isEmpty()) {
            ingredientsText.setLength(ingredientsText.length() - 2); // Remove trailing comma
        }

        ingredientsLabel.setText(ingredientsText.toString());
    }
}
