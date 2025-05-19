package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.service.RecipeService;
import com.ferrin.cookapp.service.FavoriteService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    @FXML private TabPane tabPane;
    @FXML private Tab searchTab;
    @FXML private Tab favoritesTab;
    @FXML private ListView<Recipe> favoritesListView;

    private final RecipeService recipeService = new RecipeService();
    private final FavoriteService favouriteService = new FavoriteService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            // Load cuisines from database
            List<String> cuisines = recipeService.getDistinctCuisines();

            // Add "Any" option at the beginning
            cuisines.add(0, "Any");

            // Set items in ComboBox
            cuisineComboBox.setItems(FXCollections.observableArrayList(cuisines));
            cuisineComboBox.getSelectionModel().selectFirst();

        } catch (Exception e) {
            // Fallback to default values if database query fails
            cuisineComboBox.getItems().addAll("Any", "Italian", "Asian", "Mediterranean", "Indian", "American");
            cuisineComboBox.getSelectionModel().select("Any");
            System.err.println("Failed to load cuisines from database: " + e.getMessage());
        }

        SpinnerValueFactory<Integer> valueFactory = new IntegerSpinnerValueFactory(0, 180, 60, 5);
        cookTimeSpinner.setValueFactory(valueFactory);

        // Setup the cell factory for both list views
        setupListViewCellFactory(recipeListView);
        setupListViewCellFactory(favoritesListView);

        // Add double-click event to both list views
        setupListViewDoubleClickHandler(recipeListView);
        setupListViewDoubleClickHandler(favoritesListView);

        // Add tab change listener
        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab == favoritesTab) {
                loadFavorites();
            } else if (newTab == searchTab) {
                onSearch();
            }
        });

        // Load initial recipes
        onSearch();
    }

    private void setupListViewCellFactory(ListView<Recipe> listView) {
        listView.setCellFactory(lv -> new ListCell<>() {
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
    }

    private void setupListViewDoubleClickHandler(ListView<Recipe> listView) {
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Recipe selectedRecipe = listView.getSelectionModel().getSelectedItem();
                if (selectedRecipe != null) {
                    openRecipeDetailView(selectedRecipe);
                }
            }
        });
    }

    private void loadFavorites() {
        try {
            List<Recipe> favorites = favouriteService.getFavorites();
            favoritesListView.setItems(FXCollections.observableArrayList(favorites));
        } catch (Exception e) {
            showErrorAlert("Error loading favorites", "Could not load favorite recipes: " + e.getMessage());
            favoritesListView.setItems(FXCollections.observableArrayList());
        }
    }

    private void openRecipeDetailView(Recipe recipe) {
        try {
            // Get reference to the current stage
            Stage currentStage = (Stage) recipeListView.getScene().getWindow();

            // Load the detail view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/RecipeDetailView.fxml"));
            Parent root = loader.load();

            // Get the controller and set the recipe
            RecipeDetailView controller = loader.getController();
            controller.setRecipe(recipe);
            controller.setPreviousStage(currentStage);

            // Create and configure the new stage
            Stage detailStage = new Stage();
            detailStage.setTitle(recipe.getName());

            // Create scene and add CSS
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

            detailStage.setScene(scene);
            detailStage.initModality(Modality.APPLICATION_MODAL);
            detailStage.initOwner(currentStage);

            currentStage.hide();

            // Show the detail view
            detailStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showErrorAlert("Error opening recipe details",
                    "Could not open recipe details view: " + e.getMessage());
        }
    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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