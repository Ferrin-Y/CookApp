package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Recipe;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class RecipeListView implements Initializable {

    @FXML private TextField ingredientInput;
    @FXML private ComboBox<String> cuisineComboBox;
    @FXML private Spinner<Integer> cookTimeSpinner;
    @FXML private CheckBox veganCheckBox;
    @FXML private CheckBox vegetarianCheckBox;
    @FXML private CheckBox glutenFreeCheckBox;
    @FXML private ListView<Recipe> recipeListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up cuisine options
        cuisineComboBox.getItems().addAll("Any", "Italian", "Asian", "Mediterranean", "Indian", "American");
        cuisineComboBox.getSelectionModel().select("Any");

        // Set up spinner
        SpinnerValueFactory<Integer> valueFactory = new IntegerSpinnerValueFactory(0, 180, 60, 5);
        cookTimeSpinner.setValueFactory(valueFactory);

        // Set up list view to use FXML-based custom cell
        recipeListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Recipe recipe, boolean empty) {
                super.updateItem(recipe, empty);
                if (empty || recipe == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RecipeListItem.fxml"));
                        Parent root = loader.load();
                        RecipeListItemController controller = loader.getController();
                        controller.setRecipe(recipe);
                        setGraphic(root);
                    } catch (IOException e) {
                        e.printStackTrace();
                        setText("Error loading recipe item");
                    }
                }
            }
        });

        // Initialize with all recipes
        onSearch();
    }

    @FXML
    private void onSearch() {
        String ingredientsText = ingredientInput.getText().toLowerCase().trim();
        List<String> inputIngredients = Arrays.stream(ingredientsText.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        String selectedCuisine = cuisineComboBox.getValue();
        int maxCookTime = cookTimeSpinner.getValue();
        boolean vegan = veganCheckBox.isSelected();
        boolean vegetarian = vegetarianCheckBox.isSelected();
        boolean glutenFree = glutenFreeCheckBox.isSelected();

        // Dummy recipe data
        List<Recipe> dummyRecipes = List.of(
                new Recipe("Veggie Pasta", "Pasta, Tomato, Zucchini", "Boil pasta...", 25, "Italian", "Vegetarian"),
                new Recipe("Chickpea Salad", "Chickpeas, Cucumber, Lemon", "Mix together...", 15, "Mediterranean", "Vegan"),
                new Recipe("Tofu Stir Fry", "Tofu, Chili, Bell Pepper", "Fry tofu...", 30, "Asian", "Vegan"),
                new Recipe("Mac & Cheese", "Macaroni, Cheese, Milk", "Boil, mix cheese...", 20, "American", "Vegetarian")
        );

        // Apply filters
        List<Recipe> filtered = dummyRecipes.stream()
                .filter(recipe -> inputIngredients.isEmpty() ||
                        inputIngredients.stream().allMatch(i ->
                                recipe.getQuantities().stream()
                                        .map(q -> q.getIngredient().getName().toLowerCase())
                                        .anyMatch(name -> name.contains(i))
                        ))
                .filter(recipe -> selectedCuisine == null || selectedCuisine.equals("Any") ||
                        recipe.getCuisine().equalsIgnoreCase(selectedCuisine))
                .filter(recipe -> recipe.getCookTime() <= maxCookTime)
                .filter(recipe -> {
                    String tag = recipe.getDietaryTag().toLowerCase();
                    // Only apply dietary filters if they are selected
                    if (vegan && !tag.contains("vegan")) return false;
                    if (vegetarian && !tag.contains("vegetarian") && !tag.contains("vegan")) return false;
                    if (glutenFree && !tag.contains("gluten-free")) return false;
                    return true;
                })
                .toList();

        recipeListView.setItems(FXCollections.observableArrayList(filtered));
    }
}