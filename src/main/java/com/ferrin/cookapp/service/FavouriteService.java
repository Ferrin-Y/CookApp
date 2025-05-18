package com.ferrin.cookapp.service;

import com.ferrin.cookapp.model.User;
import com.ferrin.cookapp.dao.UserDAO;
import com.ferrin.cookapp.model.Recipe;

public class FavouriteService {
    private final UserDAO userDAO = new UserDAO();
    private final AuthService authService = new AuthService();

    public void toggleFavorite(Recipe recipe) {
        User user = authService.getCurrentUser();
        if (user == null) throw new IllegalStateException("User not logged in");

        if (user.hasFavorite(recipe)) {
            user.removeFavorite(recipe);
        } else {
            user.addFavorite(recipe);
        }
        userDAO.updateUser(user);
    }

    public boolean isFavorite(Recipe recipe) {
        User user = authService.getCurrentUser();
        return user != null && user.hasFavorite(recipe);
    }
}