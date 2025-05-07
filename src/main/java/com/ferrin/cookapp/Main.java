package com.ferrin.cookapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args); // Launches the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, Cooking Suggestion App!");

        Scene scene = new Scene(label, 400, 200);
        primaryStage.setTitle("CookApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
