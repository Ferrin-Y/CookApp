package com.ferrin.cookapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file and associate it with the controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RecipeListView.fxml"));
        Parent root = loader.load();

        // Set the Scene with the loaded FXML
        Scene scene = new Scene(root);
        primaryStage.setTitle("Cooking Suggestion App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}