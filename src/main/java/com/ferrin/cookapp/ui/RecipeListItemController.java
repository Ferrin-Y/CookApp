package com.ferrin.cookapp.ui;

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
        ingredientsLabel.setText("Ingredients: " + recipe.getIngredients());
        instructionsLabel.setText("Instructions: " + recipe.getInstructions());
    }
}
