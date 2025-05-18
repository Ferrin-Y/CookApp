package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Quantity;
import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.service.AuthService;
import com.ferrin.cookapp.service.FavouriteService;
import com.ferrin.cookapp.service.QuantityService;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecipeDetailView {

    @FXML private Button backButton;
    @FXML private Label titleLabel;
    @FXML private Label title;
    @FXML private Label timeLabel;
    @FXML private Label cuisineLabel;
    @FXML private Label dietaryTagLabel;
    @FXML private ImageView recipeImageView;
    @FXML private ListView<String> ingredientsListView;
    @FXML private TextArea instructionsTextArea;
    @FXML private Button favoriteButton;

    private final QuantityService quantityService = new QuantityService();

    private final FavouriteService favouriteService = new FavouriteService();
    private final AuthService authService = new AuthService();

    private Recipe currentRecipe;
    private Stage previousStage;

    public void setRecipe(Recipe recipe) {
        this.currentRecipe = recipe;

        // Set basic recipe information
        titleLabel.setText(recipe.getName());
        title.setText(recipe.getName());
        timeLabel.setText(recipe.getCookingTime() + " min");
        cuisineLabel.setText(recipe.getCuisine());
        dietaryTagLabel.setText(recipe.getDietaryTag());
        instructionsTextArea.setText(recipe.getInstructions());

        // Load recipe image - using a placeholder for now
        try {
            recipeImageView.setImage(new Image(getClass().getResourceAsStream("/images/recipe_placeholder.jpg")));
        } catch (Exception e) {
            System.err.println("Could not load recipe image: " + e.getMessage());
            // Set a default background color for the image view
            recipeImageView.setStyle("-fx-background-color: #f0f0f0;");
        }

        // Load ingredients
        loadIngredients(recipe.getId());
        updateFavouriteButton();
    }

    private void loadIngredients(Long recipeId) {
        List<Quantity> quantities = quantityService.getQuantitiesForRecipe(recipeId);
        List<String> ingredientTexts = new ArrayList<>();

        for (Quantity q : quantities) {
            StringBuilder sb = new StringBuilder();
            if (q.getAmount() != null && !q.getAmount().isEmpty()) {
                sb.append(q.getAmount()).append(" ");
            }
            if (q.getUnit() != null && !q.getUnit().isEmpty()) {
                sb.append(q.getUnit()).append(" ");
            }
            sb.append(q.getIngredient().getName());

            ingredientTexts.add(sb.toString());
        }

        ingredientsListView.setItems(FXCollections.observableArrayList(ingredientTexts));
    }

    public void setPreviousStage(Stage stage) {
        this.previousStage = stage;
    }

    @FXML
    private void onBackButtonClick(ActionEvent event) {
        if (previousStage != null) {
            previousStage.show();
        }

        // Close the current window
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    private void updateFavouriteButton() {
        if (authService.getCurrentUser() != null) {
            favoriteButton.setVisible(true);
            favoriteButton.setText(favouriteService.isFavorite(currentRecipe) ? "★ Favorited" : "☆ Favorite");
        } else {
            favoriteButton.setVisible(false);
        }
    }

    @FXML
    private void onFavoriteButtonClick() {
        favouriteService.toggleFavorite(currentRecipe);
        updateFavouriteButton();
    }
}