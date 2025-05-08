package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RecipeListView {

    @FXML
    private ListView<Recipe> recipeListView;

    public void initialize() {
        ObservableList<Recipe> recipeData = FXCollections.observableArrayList(fetchRecipes());
        recipeListView.setItems(recipeData);

        recipeListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(Recipe recipe, boolean empty) {
                super.updateItem(recipe, empty);
                if (empty || recipe == null) {
                    setGraphic(null);
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RecipeListItem.fxml"));
                        VBox vbox = loader.load();  // Change to VBox, since RecipeListItem.fxml uses VBox
                        RecipeListItemController controller = loader.getController();
                        controller.setRecipe(recipe);
                        setGraphic(vbox);  // Set VBox instead of AnchorPane
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private List<Recipe> fetchRecipes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Recipe> query = session.createQuery("from Recipe", Recipe.class);
            return query.list();
        }
    }
}
