package com.ferrin.cookapp;

import com.ferrin.cookapp.service.AuthService;
import com.ferrin.cookapp.ui.LoginDialog;
import com.ferrin.cookapp.util.DataInitializer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        try {
            // Initialize sample data including admin user
            DataInitializer.initializeAdmin();

            // First make the stage visible with minimal content
            primaryStage.setScene(new Scene(new StackPane(), 300, 200));
            primaryStage.setTitle("CookApp - Loading...");
            primaryStage.show();

            // Then show the login dialog
            showLoginDialog();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Startup Error",
                    "Failed to start application: " + e.getMessage());
            e.printStackTrace();
            Platform.exit();
        }
    }

    private void showLoginDialog() {
        try {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("CookApp Authentication");

            // Set the owner properly - BEFORE showing the dialog
            dialog.initOwner(primaryStage);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginDialog.fxml"));
            DialogPane dialogPane = loader.load();
            dialog.setDialogPane(dialogPane);

            LoginDialog controller = loader.getController();
            controller.setDialogPane(dialogPane);

            Optional<ButtonType> result = dialog.showAndWait();
            result.ifPresent(buttonType -> {
                if (AuthService.isLoggedIn()) {
                    showMainApplication();
                } else if (buttonType.getButtonData() == ButtonBar.ButtonData.OTHER) {
                    // Register button was clicked
                    showLoginDialog(); // Reopen for login
                } else {
                    Platform.exit();
                }
            });
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load login dialog: " + e.getMessage());
            e.printStackTrace();
            Platform.exit();
        }
    }

    private void showMainApplication() {
        try {
            // Close the temporary stage
            primaryStage.close();

            // Create new main stage
            Stage mainStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/RecipeListView.fxml"));
            Scene scene = new Scene(root);

            mainStage.setScene(scene);
            mainStage.setTitle("CookApp - Recipe Explorer");
            mainStage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Failed to load main application: " + e.getMessage());
            e.printStackTrace();
            Platform.exit();
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}