package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.util.HibernateUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RecipeListView {

    @FXML
    private TableView<Recipe> recipeTable;

    @FXML
    private TableColumn<Recipe, String> nameColumn;

    @FXML
    private TableColumn<Recipe, String> ingredientsColumn;

    @FXML
    private TableColumn<Recipe, String> instructionsColumn;

    public void initialize() {
        // Initialize the columns with StringProperty instead of String
        nameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        ingredientsColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getIngredients()));
        instructionsColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getInstructions()));

        // Fetch the recipes from the database and set the table data
        ObservableList<Recipe> recipeData = FXCollections.observableArrayList(fetchRecipes());
        recipeTable.setItems(recipeData);
    }

    // Fetch all recipes from the database
    private List<Recipe> fetchRecipes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Recipe> query = session.createQuery("from Recipe", Recipe.class);
            return query.list();
        }
    }
}
