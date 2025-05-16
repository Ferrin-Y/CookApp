package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Quantity;
import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.service.QuantityService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class RecipeListItemController {

    @FXML private VBox container;
    @FXML private Label nameLabel;
    @FXML private Label ingredientsLabel;

    private final QuantityService quantityService = new QuantityService();

    public void setRecipe(Recipe recipe) {
        nameLabel.setText(recipe.getName());
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

        container.setOnMouseEntered(e -> container.setStyle("-fx-background-color: #f0f0f0;"));
        container.setOnMouseExited(e -> container.setStyle("-fx-background-color: #fdfdfd;"));
    }
}
