package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.service.RecipeService;
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

    private final RecipeService recipeService = new RecipeService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cuisineComboBox.getItems().addAll("Any", "Italian", "Asian", "Mediterranean", "Indian", "American");
        cuisineComboBox.getSelectionModel().select("Any");

        SpinnerValueFactory<Integer> valueFactory = new IntegerSpinnerValueFactory(0, 180, 60, 5);
        cookTimeSpinner.setValueFactory(valueFactory);

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
                        controller.setRecipe(recipe); // Let item controller fetch quantities
                        setGraphic(root);
                    } catch (IOException e) {
                        e.printStackTrace();
                        setText("Error loading recipe item");
                    }
                }
            }
        });

        onSearch(); // Load all recipes initially
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

        List<Recipe> results = recipeService.searchRecipes(
                inputIngredients,
                selectedCuisine,
                maxCookTime,
                vegan,
                vegetarian,
                glutenFree
        );

        recipeListView.setItems(FXCollections.observableArrayList(results));
    }
}
