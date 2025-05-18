package com.ferrin.cookapp.ui;

import com.ferrin.cookapp.dao.UserDAO;
import com.ferrin.cookapp.model.User;
import com.ferrin.cookapp.service.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginDialog {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private boolean loginSuccessful = false;
    private final AuthService authService = new AuthService();
    private final UserDAO userDAO = new UserDAO();

    public void setDialogPane(DialogPane dialogPane) {
        // Clear any previous session
        AuthService.logout();

        // Define button types - these need to match exactly with the FXML
        ButtonType loginButtonType = ButtonType.OK; // "Login" button
        ButtonType registerButtonType = new ButtonType("Register", ButtonBar.ButtonData.OTHER);
        ButtonType cancelButtonType = ButtonType.CANCEL; // "Cancel" button

        // Get buttons safely - only proceed if they exist
        Button loginButton = (Button) dialogPane.lookupButton(loginButtonType);
        Button registerButton = (Button) dialogPane.lookupButton(registerButtonType);

        // Verify buttons exist before adding behavior
        if (loginButton != null) {
            loginButton.setText("Login"); // Ensure text matches what's expected
            loginButton.addEventFilter(ActionEvent.ACTION, event -> {
                if (!handleLogin()) {
                    event.consume();
                } else {
                    // Close the dialog on successful login
                    ((Stage) dialogPane.getScene().getWindow()).close();
                }
            });
        }

        if (registerButton != null) {
            registerButton.addEventFilter(ActionEvent.ACTION, event -> {
                handleRegistration();
                event.consume();
            });
        }
    }

    private boolean handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Both fields are required");
            return false;
        }

        if (AuthService.login(username, password)) {
            loginSuccessful = true; // Set this flag to true on successful login
            return true;
        }

        showError("Invalid username or password");
        return false;
    }

    private void handleRegistration() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Both fields are required");
            return;
        }

        try {
            if (userDAO.findByUsername(username).isPresent()) {
                showError("Username already exists");
                return;
            }

            User newUser = new User(username, password, username, "", User.Role.USER);
            userDAO.saveUser(newUser);
            showSuccess("Registration successful! Please login");
        } catch (Exception e) {
            showError("Registration failed: " + e.getMessage());
        }
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    private void showError(String message) {
        errorLabel.getStyleClass().remove("success-label");
        errorLabel.getStyleClass().add("error-label");
        errorLabel.setText(message);
        passwordField.clear();
    }

    private void showSuccess(String message) {
        errorLabel.getStyleClass().remove("error-label");
        errorLabel.getStyleClass().add("success-label");
        errorLabel.setText(message);
        usernameField.clear();
        passwordField.clear();
    }
}