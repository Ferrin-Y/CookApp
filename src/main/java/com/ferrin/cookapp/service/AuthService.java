package com.ferrin.cookapp.service;

import com.ferrin.cookapp.model.User;
import com.ferrin.cookapp.dao.UserDAO;
import java.util.Optional;

public class AuthService {
    private static User currentUser;
    private static final UserDAO userDAO = new UserDAO();

    public static boolean login(String username, String password) {
        try {
            Optional<User> userOpt = userDAO.findByUsername(username);
            if (userOpt.isPresent() && userOpt.get().verifyPassword(password)) {
                currentUser = userOpt.get();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void logout() {
        currentUser = null;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isAdmin() {
        return currentUser != null && currentUser.getRole() == User.Role.ADMIN;
    }
}