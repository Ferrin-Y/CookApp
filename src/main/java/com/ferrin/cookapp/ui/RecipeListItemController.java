package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Quantity;
import com.ferrin.cookapp.model.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RecipeListItemController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label ingredientsLabel;

    @FXML
    private Label instructionsLabel;

    public void setRecipe(Recipe recipe) {
        nameLabel.setText(recipe.getName());

        // Build ingredients string from quantities
        StringBuilder ingredientsText = new StringBuilder("Ingredients: ");
        for (Quantity q : recipe.getQuantities()) {
            ingredientsText.append(q.getAmount())
                    .append(" ")
                    .append(q.getUnit())
                    .append(" ")
                    .append(q.getIngredient().getName())
                    .append(", ");
        }

        if (!recipe.getQuantities().isEmpty()) {
            // Remove trailing comma and space
            ingredientsText.setLength(ingredientsText.length() - 2);
        }

        ingredientsLabel.setText(ingredientsText.toString());
        instructionsLabel.setText("Instructions: " + recipe.getInstructions());
    }
}
